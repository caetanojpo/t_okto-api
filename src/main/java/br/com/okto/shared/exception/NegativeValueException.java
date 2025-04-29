package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public class NegativeValueException extends OktoException {
    private static final String MSG_TEMPLATE =
            "The informed value for method [%s.%s] is 0 or negative";
    private static final String CODE = "BAD_REQUEST";
    private static final Response.Status STATUS = Response.Status.BAD_REQUEST;

    public NegativeValueException(String className, String method) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, className, method),
                null,
                null
        );
    }
}
