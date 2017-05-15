package rest;

import connectors.MongoConnector;
import connectors.RedisConnector;
import data.AirportInfo;
import rest.exceptions.CodeNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Response getAllMetartForAirport(@PathParam("code") String code) {
        GenericEntity<List<AirportInfo>> entity = new GenericEntity<List<AirportInfo>>(MongoConnector.getInstance().getAllAirportInfoByAirportCode("ZAEMG")) {
        };
        return Response.ok(entity).build();
    }
}
