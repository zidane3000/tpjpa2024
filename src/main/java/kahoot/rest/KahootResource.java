package kahoot.rest;

import kahoot.dao.implDao.KahootDao;
import kahoot.domain.Kahoot;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kahoot.service.KahootService;


import java.util.List;

@Path("/kahoots")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KahootResource {

    private KahootService kahootService = new KahootService();
    private KahootDao kahootDao = kahootService.getKahootDao();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Kahoot> getAllKahoots() {

        return kahootDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKahootById(@PathParam("id") Long id) {
        Kahoot kahoot = kahootDao.findOne(id);
        if (kahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Kahoot not found").build();
        }
        return Response.ok(kahoot).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createKahoot(Kahoot kahoot) {
        kahootDao.save(kahoot);
        return Response.status(Response.Status.CREATED).entity(kahoot).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKahoot(@PathParam("id") Long id, Kahoot kahoot) {
        Kahoot existingKahoot = kahootDao.findOne(id);
        if (existingKahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Kahoot not found").build();
        }
        kahoot.setId(id); // Assure-toi que l'ID est bien mis à jour
        kahootDao.update(kahoot);
        return Response.ok(kahoot).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKahoot(@PathParam("id") Long id) {
        Kahoot existingKahoot = kahootDao.findOne(id);
        if (existingKahoot == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Kahoot not found").build();
        }
        kahootDao.deleteById(id);
        return Response.noContent().build();
    }
}

