package kahoot.dto;

import kahoot.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperDTO {

    MapperDTO INSTANCE = Mappers.getMapper(MapperDTO.class);

    KahootDTO toKahootDTO(Kahoot kahoot);
    Kahoot toKahootEntity(KahootDTO kahootDTO);

    UtilisateurDTO toUtilisateurDTO(Utilisateur utilisateur);

    CreateurDTO toCreateurDTO(Createur createur);
    Createur toCreateurEntity(CreateurDTO createurDTO);

    ParticipantDTO toParticipantDTO(Participant participant);
    Participant toParticipantEntity(ParticipantDTO participantDTO);

    QuestionDTO toQuestionDTO(Question question);
    Question toQuestionEntity(QuestionDTO questionDTO);

    ReponsePossibleDTO toReponsePossibleDTO(ReponsePossible reponse);
    ReponsePossible toReponsePossibleEntity(ReponsePossible reponse);

    ReponseParticipantDTO toReponseParticipantDTO(ReponseParticipant reponse);
    ReponseParticipant toReponseParticipantEntity(ReponseParticipant reponse);


    /*
    public static KahootDTO toKahootDTO(Kahoot kahoot) {
        KahootDTO kahootDTO = new KahootDTO();
        kahootDTO.setId(kahoot.getId());
        kahootDTO.setTitre(kahoot.getTitre());
        kahootDTO.setCreateurId(kahoot.getCreateur().getId());
        kahootDTO.setPin(kahoot.getPIN());
        kahootDTO.setType(kahoot.getType());
        return kahootDTO;
    }

    public static UtilisateurDTO toUtilisateurDTO(Utilisateur utilisateur) {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setSurnom(utilisateur.getSurnom());
        return utilisateurDTO;
    }

    public static QuestionDTO toQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setTexteQuestion(question.getTexteQuestion());
        questionDTO.setTypeQuestion(question.getTypeQuestion());
        Kahoot kahoot = question.getKahoot();
        if(kahoot != null) {
            questionDTO.setKahoot_id(kahoot.getId());
        }
        return questionDTO;
    }

    public static ReponsePossibleDTO toReponsePossibleDTO(ReponsePossible reponse) {
        ReponsePossibleDTO reponseDTO = new ReponsePossibleDTO();
        reponseDTO.setId(reponse.getId());
        reponseDTO.setTexteReponse(reponse.getTexteReponse());
        reponseDTO.setCorrect(reponse.getCorrect());
        reponseDTO.setQuestion_id(reponse.getQuestion().getId());
        return reponseDTO;
    }
    */

}
