package rest;

import connectors.MySQLConnector;
import connectors.Neo4jConnector;
import data.Airport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by sitora on 18.05.17.
 */

@Path("/airports")
public class AirportResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("info/{code}")
    public Response getAirportInfo(@PathParam("code") String code) {
        try {
            Airport airport = MySQLConnector.getInstance().get(code.toUpperCase());

            if (airport == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Airport with iata code " + code + " not found").build();
            }
            return Response.ok(airport, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Airport with iata code " + code + " not found").build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response addNewAirport(Airport airport) {
        try {
            MySQLConnector.getInstance().save(airport);
            Neo4jConnector.getInstance().save(airport.getCode().toUpperCase());
            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You got errors.").build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remove/{code}")
    public Response removeAirport(@PathParam("code") String code) {
        try {
            MySQLConnector.getInstance().remove(code.toUpperCase());

            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Airport with iata code " + code + " not exist").build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response updateAirport(Airport airport) {
        try {
            MySQLConnector.getInstance().update(airport);
            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You got errors.").build();
        }
    }
}
