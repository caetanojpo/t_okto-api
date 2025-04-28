package br.com.okto.modules.user.adapter.in.rest.handler;

import br.com.okto.shared.dto.ErrorResponse;
import br.com.okto.shared.exception.OktoException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Provider
@ApplicationScoped
@Slf4j
public class OktoExceptionMapper implements ExceptionMapper<OktoException> {

    @Override
    public Response toResponse(OktoException exception) {
        logError(exception);

        ErrorResponse payload = new ErrorResponse(exception.getCode(), exception.getMessage(), Instant.now());

        return Response.status(exception.getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(payload)
                .build();
    }

    private void logError(OktoException exception) {
        if (exception.getStatus().getFamily() == Response.Status.Family.SERVER_ERROR) {
            log.error("Unhandled internal error", exception);
        } else {
            log.warn("Okto exception caught", exception);
        }
    }
}
