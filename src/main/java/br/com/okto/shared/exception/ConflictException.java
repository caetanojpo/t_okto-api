package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public class ConflictException extends OktoException {
    private static final String MSG_TEMPLATE =
            "The entity [%s] already exists. Informed data -> %s";
    private static final String CODE = "CONFLICT";
    private static final Response.Status STATUS = Response.Status.CONFLICT;

    public ConflictException(String entity) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, entity.toUpperCase(), "no additional data"),
                null,
                null
        );
    }

    public ConflictException(String entity, String informedData, String field) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, entity.toUpperCase(), informedData),
                null,
                field
        );
    }

    public ConflictException(String entity,String informedData, String field, Throwable cause) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, entity.toUpperCase(), informedData),
                cause,
                field
        );
    }

}
