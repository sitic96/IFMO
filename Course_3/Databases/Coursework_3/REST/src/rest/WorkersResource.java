package rest;

import connectors.CassandraConnector;
import data.Worker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sitora on 19.05.17.
 */
@Path("/workers")
public class WorkersResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{name}/{lastName}")
    public Response getWorkersInfo(@PathParam("name") String name, @PathParam("lastName") String lastName) {
        try {
            List<Worker> workerList = CassandraConnector.getInstance().get(name, lastName);
            return Response.ok().entity(workerList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Exception in params").build();
        }
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("remove/{name}/{lastName}")
    public Response removeWorker(@PathParam("name") String name, @PathParam("lastName") String lastName) {
        try {
            CassandraConnector.getInstance().remove(name, lastName);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Exception in params").build();
        }
    }

    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addWorker(Worker worker) {
        try {
            CassandraConnector.getInstance().save(worker);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Exception in params").build();

        }
    }
}
