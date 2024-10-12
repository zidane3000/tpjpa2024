package kahoot.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kahoot.dao.implDao.KahootDao;
import kahoot.dao.implDao.QuestionDao;
import kahoot.domain.Createur;
import kahoot.domain.Kahoot;
import kahoot.domain.Question;
import kahoot.dto.MapperDTO;
import kahoot.dto.QuestionDTO;
import kahoot.service.KahootService;
import kahoot.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

@Path("questions")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class QuestionResource {

    private QuestionService questionService = new QuestionService();
    private QuestionDao questionDao = questionService.getQuestionDao();
    private KahootDao kahootDao = (new KahootService()).getKahootDao();

    @GET
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionDao.findAll();
        return questions.stream()
                .map(MapperDTO::toQuestionDTO) // Utiliser le mapper pour convertir
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getQuestionById(@PathParam("id") Long id) {
        Question question = questionDao.findOne(id);
        if (question != null) {
            return Response.ok(MapperDTO.toQuestionDTO(question)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/create")
    public Response createQuestion( QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTexteQuestion(questionDTO.getTexteQuestion());
        question.setTypeQuestion(questionDTO.getTypeQuestion());
        Kahoot kahoot = kahootDao.findOne(questionDTO.getKahoot_id());
        question.setKahoot(kahoot);
        questionDao.save(question);
        return Response.status(Response.Status.CREATED)
                .entity(MapperDTO.toQuestionDTO(question))
                .build();
    }

    @PUT
    @Path("update/{id}")
    public Response updateQuestion(@PathParam("id") Long id, QuestionDTO questionDTO) {
        Question existingQuestion = questionDao.findOne(id);
        if (existingQuestion == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Question not found").build();
        }

        existingQuestion.setTypeQuestion(questionDTO.getTypeQuestion());
        existingQuestion.setTexteQuestion(questionDTO.getTexteQuestion());
        questionDao.update(existingQuestion);

        return Response.ok(MapperDTO.toQuestionDTO(existingQuestion)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteQuestion(@PathParam("id") Long id) {
        Question existingQuestion= questionDao.findOne(id);
        if (existingQuestion == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Question not found").build();
        }

        questionDao.deleteById(id);
        return Response.noContent().build();
    }
}
