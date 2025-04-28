package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public abstract class OktoException extends RuntimeException {
    private final String code;
    private final Response.Status status;
    private final String field;

    protected OktoException(String code, Response.Status status, String message) {
        this(code, status, message, null, null);
    }

    protected OktoException(String code, Response.Status status, String message, Throwable cause) {
        this(code, status, message, cause, null);
    }

    protected OktoException(
            String code,
            Response.Status status,
            String message,
            Throwable cause,
            String field
    ) {
        super(message, cause);
        this.code = code;
        this.status = status;
        this.field = field;
    }

    public String getCode() {
        return code;
    }

    public Response.Status getStatus() {
        return status;
    }

    public String getField() {
        return field;
    }
}
