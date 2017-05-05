package rest;

import connectors.RedisConnector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sitora on 03.05.17.
 */

@Path("/metar")
public class METARResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("current/{code}")
    public String getCurrentMetarByAirportCode(@PathParam("code") String code) {
        return RedisConnector.getInstance().get(code);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("all/{code}")
    public Response getAllMetartForAirport(@PathParam("code") String code) {
       // List<AirportInfo> =
        return null;
        //TODO DO DO DO
    }
}
