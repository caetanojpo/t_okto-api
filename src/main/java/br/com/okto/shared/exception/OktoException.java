package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public abstract class OktoException extends RuntimeException {
    private final String code;
    private final Response.Status status;

    protected OktoException(String code, Response.Status status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    protected OktoException(String code, Response.Status status, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public Response.Status getStatus() {
        return status;
    }
}
