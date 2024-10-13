package kahoot.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kahoot.dao.implDao.CreateurDao;
import kahoot.dao.implDao.KahootDao;
import kahoot.dao.implDao.ParticipantDao;
import kahoot.dao.implDao.UtilisateurDao;
import kahoot.domain.Createur;
import kahoot.domain.Kahoot;
import kahoot.domain.Participant;
import kahoot.domain.Utilisateur;
import kahoot.dto.CreateurDTO;
import kahoot.dto.ParticipantDTO;
import kahoot.dto.MapperDTO;
import kahoot.dto.UtilisateurDTO;
import kahoot.service.CreateurService;
import kahoot.service.KahootService;
import kahoot.service.ParticipantService;
import kahoot.service.UtilisateurService;
import org.mapstruct.factory.Mappers;

@Path("utilisateurs")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UtilisateurResource {

    private KahootDao kahootDao = new KahootService().getKahootDao();

    private UtilisateurDao utilisateurDao = new UtilisateurService().getUtilisateurDao();
    private ParticipantDao participantDao = new ParticipantService().getParticipantDao();
    private CreateurDao createurDao = new CreateurService().getCreateurDao();
    private MapperDTO mapperDTO = Mappers.getMapper(MapperDTO.class);

    @POST
    @Path("/create/createur")
    public Response createCreateur(CreateurDTO createurDTO) {
        Createur createur = mapperDTO.toCreateurEntity(createurDTO);
        createurDao.save(createur);
        return Response.status(Response.Status.CREATED).entity(mapperDTO.toCreateurDTO(createur)).build();
    }

    @POST
    @Path("/create/participant")
    public Response createParticipant(ParticipantDTO participantDTO) {
        // Récupération du Kahoot en utilisant l'identifiant du DTO
        Kahoot kahoot = kahootDao.findOne(participantDTO.getKahoot_id());
        if (kahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error: Kahoot does not exist").build();
        }

        // Conversion du DTO en entité Participant
        Participant participant = mapperDTO.toParticipantEntity(participantDTO);
        // Association du Kahoot au Participant
        participant.setKahoot(kahoot);

        // Sauvegarde du Participant
        participantDao.save(participant);
        return Response.status(Response.Status.CREATED).entity(mapperDTO.toParticipantDTO(participant)).build();
    }


    @GET
    @Path("/{id}")
    public Response getUtilisateurById(@PathParam("id") Long id) {
        Utilisateur utilisateur = utilisateurDao.findOne(id);
        if (utilisateur != null) {
            if (utilisateur instanceof Createur) {
                return Response.ok(mapperDTO.toCreateurDTO((Createur) utilisateur)).build();
            } else if (utilisateur instanceof Participant) {
                return Response.ok(mapperDTO.toParticipantDTO((Participant) utilisateur)).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateUtilisateur(@PathParam("id") Long id, UtilisateurDTO utilisateurDTO) {
        Utilisateur existingUtilisateur = utilisateurDao.findOne(id);
        if (existingUtilisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Utilisateur not found").build();
        }

        existingUtilisateur.setSurnom(utilisateurDTO.getSurnom());
        utilisateurDao.update(existingUtilisateur);

        return Response.ok(mapperDTO.toUtilisateurDTO(existingUtilisateur)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUtilisateur(@PathParam("id") Long id) {
        Utilisateur existingUtilisateur = utilisateurDao.findOne(id);
        if (existingUtilisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Utilisateur not found").build();
        }

        utilisateurDao.deleteById(id);
        return Response.noContent().build();
    }
}

