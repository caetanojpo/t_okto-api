package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public class EntityNotFoundException extends OktoException {

    private static final String MSG_TEMPLATE =
            "Entity [%s] not found: %s";
    private static final String CODE = "NOT_FOUND";
    private static final Response.Status STATUS = Response.Status.NOT_FOUND;

    public EntityNotFoundException(String entity) {
        super(CODE, STATUS, String.format(MSG_TEMPLATE, entity.toUpperCase(), "no additional details"));
    }

    public EntityNotFoundException(String entity, Throwable cause) {
        super(CODE, STATUS, String.format(MSG_TEMPLATE, entity.toUpperCase(), cause.getMessage()), cause);
    }
}