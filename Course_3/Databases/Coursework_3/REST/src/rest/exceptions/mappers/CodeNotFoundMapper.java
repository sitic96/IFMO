package rest.exceptions.mappers;

import rest.exceptions.CodeNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by sitora on 15.05.17.
 */
@Provider
public class CodeNotFoundMapper implements
        ExceptionMapper<CodeNotFoundException> {
    @Override
    public Response toResponse(CodeNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain")
                .build();
    }
}