package kahoot.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kahoot.dao.implDao.KahootDao;
import kahoot.dao.implDao.UtilisateurDao;
import kahoot.domain.Createur;
import kahoot.domain.Kahoot;
import kahoot.dto.KahootDTO;
import kahoot.dto.MapperDTO;
import kahoot.service.KahootService;
import kahoot.service.UtilisateurService;

import java.util.List;
import java.util.stream.Collectors;


@Path("kahoots")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class KahootResource {

    private KahootService kahootService = new KahootService();
    private KahootDao kahootDao = kahootService.getKahootDao();

    private UtilisateurDao utilisateurDao = (new UtilisateurService()).getUtilisateurDao();

    @GET
    public List<KahootDTO> getAllKahoots() {
        List<Kahoot> kahoots = kahootDao.findAll();
        return kahoots.stream()
                .map(MapperDTO::toKahootDTO) // Utiliser le mapper pour convertir
                .collect(Collectors.toList());
    }


    @GET
    @Path("/{id}")
    public Response getKahootById(@PathParam("id") Long id) {
        Kahoot kahoot = kahootDao.getKahootById(id);
        if (kahoot != null) {
            return Response.ok(MapperDTO.toKahootDTO(kahoot)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/createKahoot")
    public Response createKahoot( KahootDTO kahootDTO) {
        Kahoot kahoot = new Kahoot();
        kahoot.setTitre(kahootDTO.getTitre());
        kahoot.setType(kahootDTO.getType());
        kahoot.setPIN(kahootDTO.getPin());
        Createur createur = (Createur) utilisateurDao.findOne(kahootDTO.getCreateurId());
        kahoot.setCreateur(createur);

        kahootDao.save(kahoot);
        return Response.status(Response.Status.CREATED)
                .entity(MapperDTO.toKahootDTO(kahoot))
                .build();
    }

    @PUT
    @Path("updateKahoot/{id}")
    public Response updateKahoot(@PathParam("id") Long id, KahootDTO kahootDTO) {
        Kahoot existingKahoot = kahootDao.findOne(id);
        if (existingKahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Kahoot not found").build();
        }

        existingKahoot.setTitre(kahootDTO.getTitre());
        existingKahoot.setType(kahootDTO.getType());
        kahootDao.update(existingKahoot);

        return Response.ok(MapperDTO.toKahootDTO(existingKahoot)).build();
    }

    @DELETE
    @Path("/deleteKahoot/{id}")
    public Response deleteKahoot(@PathParam("id") Long id) {
        Kahoot existingKahoot = kahootDao.findOne(id);
        if (existingKahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Kahoot not found").build();
        }

        kahootDao.deleteById(id);
        return Response.noContent().build();
    }

}

