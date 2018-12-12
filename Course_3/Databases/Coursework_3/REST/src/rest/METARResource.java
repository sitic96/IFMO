package rest;

import connectors.MongoConnector;
import connectors.RedisConnector;
import data.AirportInfo;
import rest.exceptions.CodeNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sitora on 03.05.17.
 */

@Path("/metar")
public class METARResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("current/{code}")
    public String getCurrentMetarByAirportCode(@PathParam("code") String code) throws CodeNotFoundException {
        String metar = RedisConnector.getInstance().get(code);
        if (metar != null) {
            return metar;
        } else throw new CodeNotFoundException("Incorrect IKAO code");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("all/{code}")
    public Response getAllMetarForAirport(@PathParam("code") String code) {
        GenericEntity<List<AirportInfo>> entity;
        try {
            List<AirportInfo> info = MongoConnector.getInstance().getAllAirportInfoByAirportCode(code.toUpperCase());
            if (info.isEmpty() || info.size() == 0) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Airport with iata code " + code + " not exist").build();
            }
            entity = new GenericEntity<List<AirportInfo>>(info) {
            };
            return Response.ok(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Airport with iata code " + code + " not exist").build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("remove/{code}")
    public Response removeMetar(@PathParam("code") String code) {
        try {
            MongoConnector.getInstance().remove(code);
            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Remove is impossible. Check input data.").build();
        }
    }

    @PUT
    @Path("/update/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response updateAirport(AirportInfo metar) {
        try {
            MongoConnector.getInstance().update(metar);
            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You got errors.").build();
        }
    }

    @POST
    @Path("/add/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response addirport(AirportInfo metar) {
        try {
            MongoConnector.getInstance().save(metar);
            return Response.ok(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You got errors.").build();
        }
    }
}
