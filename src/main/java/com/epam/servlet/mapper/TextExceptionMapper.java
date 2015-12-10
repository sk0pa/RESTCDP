package com.epam.servlet.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TextExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    public Response toResponse(IllegalArgumentException exception) {
        return Response
                .status(400)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
