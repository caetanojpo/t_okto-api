package br.com.okto.shared.exception;

public class ConflictException extends RuntimeException {
    private static final String MSG_TEMPLATE =
            "The entity %s already exists. Informed data -> %s";

    public ConflictException(String entity) {
        super(String.format(MSG_TEMPLATE, entity, "no additional data"));
    }

    public ConflictException(String entity, String informedData) {
        super(String.format(MSG_TEMPLATE, entity, informedData));
    }
}
