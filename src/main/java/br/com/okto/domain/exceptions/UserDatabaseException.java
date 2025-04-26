package br.com.okto.domain.exceptions;

public class UserDatabaseException extends RuntimeException{

    private static final String MSG_TEMPLATE =
            "Error in UserRepository.%s: %s";

    public UserDatabaseException(String repositoryMethod) {
        super(String.format(MSG_TEMPLATE, repositoryMethod, "no additional details"));
    }

    public UserDatabaseException(String repositoryMethod, Throwable cause) {
        super(String.format(MSG_TEMPLATE, repositoryMethod, cause.getMessage()), cause);
    }
}
