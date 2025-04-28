package br.com.okto.shared.exception;

import jakarta.ws.rs.core.Response;

public class DatabaseException extends OktoException {

    private static final String MSG_TEMPLATE =
            "Error in [%s.%s]: %s";
    private static final String CODE = "CONFLICT";
    private static final Response.Status STATUS = Response.Status.CONFLICT;

    public DatabaseException(String repository, String repositoryMethod) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, repository, repositoryMethod, "no additional details"),
                null,
                repositoryMethod
        );
    }

    public DatabaseException(String repository, String repositoryMethod, Throwable cause) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, repository, repositoryMethod, cause.getMessage()),
                cause,
                repositoryMethod
        );
    }

    public DatabaseException(
            String repository,
            String repositoryMethod,
            String messageDetail,
            Throwable cause
    ) {
        super(
                CODE,
                STATUS,
                String.format(MSG_TEMPLATE, repository, repositoryMethod, messageDetail),
                cause,
                repositoryMethod
        );
    }
}
