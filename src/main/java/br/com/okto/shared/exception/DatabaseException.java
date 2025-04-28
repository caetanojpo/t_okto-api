package br.com.okto.shared.exception;

public class DatabaseException extends RuntimeException {

    private static final String MSG_TEMPLATE =
            "Error in %sRepository.%s: %s";

    public DatabaseException(String repository, String repositoryMethod) {
        super(String.format(MSG_TEMPLATE, repository, repositoryMethod, "no additional details"));
    }

    public DatabaseException(String repository, String repositoryMethod, Throwable cause) {
        super(String.format(MSG_TEMPLATE,  repository, repositoryMethod, cause.getMessage()), cause);
    }
}
