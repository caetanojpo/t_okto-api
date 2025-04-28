package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public class DatabaseException extends OktoException {

    private static final String MSG_TEMPLATE =
            "Error in %sRepository.%s: %s";
    private static final String CODE = "CONFLICT";
    private static final Response.Status STATUS = Response.Status.CONFLICT;

    public DatabaseException(String repository, String repositoryMethod) {
        super(CODE, STATUS, String.format(MSG_TEMPLATE, repository, repositoryMethod, "no additional details"));
    }

    public DatabaseException(String repository, String repositoryMethod, Throwable cause) {
        super(CODE, STATUS, String.format(MSG_TEMPLATE,  repository, repositoryMethod, cause.getMessage()), cause);
    }
}
