package br.com.okto.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private static final String MSG_TEMPLATE =
            "Entity [%s] not found: %s";

    public EntityNotFoundException(String entity) {
        super(String.format(MSG_TEMPLATE, entity.toUpperCase(), "no additional details"));
    }

    public EntityNotFoundException(String entity, Throwable cause) {
        super(String.format(MSG_TEMPLATE, entity.toUpperCase(), cause.getMessage()), cause);
    }
}