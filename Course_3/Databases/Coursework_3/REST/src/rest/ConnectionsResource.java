package rest;

import connectors.Neo4jConnector;
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
 * Created by sitora on 17.05.17.
 */
@Path("/conn")
public class ConnectionsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{code}")
    public Response getCurrentMetarByAirportCode(@PathParam("code") String code) throws CodeNotFoundException {
        if (code != null && code != "") {
            GenericEntity<List<String>> entity;
            List<String> codes = (Neo4jConnector.getInstance().getConnectedAirports(code));
            if (!codes.isEmpty() && code != null) {
                if (codes.get(0) != null) {
                    entity = new GenericEntity<List<String>>(codes) {
                    };
                } else throw new CodeNotFoundException("Wrong iata code or airport doesn't exist.");
            } else throw new CodeNotFoundException("Wrong iata code or airport doesn't exist.");
            return Response.ok(entity).build();
        } else throw new CodeNotFoundException("Wrong iata code or airport doesn't exist.");
    }
}
