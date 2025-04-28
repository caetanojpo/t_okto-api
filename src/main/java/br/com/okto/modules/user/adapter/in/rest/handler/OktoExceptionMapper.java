package br.com.okto.modules.user.adapter.in.rest.handler;

import br.com.okto.shared.dto.ApiResponse;
import br.com.okto.shared.dto.ErrorInfo;
import br.com.okto.shared.exception.OktoException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

import static java.util.Collections.singletonList;

@Provider
@ApplicationScoped
@Slf4j
public class OktoExceptionMapper implements ExceptionMapper<OktoException> {

    @Override
    public Response toResponse(OktoException exception) {
        logError(exception);

        ErrorInfo errorInfo = new ErrorInfo(
                exception.getCode(),
                exception.getMessage(),
                exception.getField()
        );

        ApiResponse<Void> payload = ApiResponse.error(
                singletonList(errorInfo)
        );

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
