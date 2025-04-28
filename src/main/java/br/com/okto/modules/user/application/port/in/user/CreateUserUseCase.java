package br.com.okto.modules.user.application.port.in.user;

import br.com.okto.modules.user.application.dto.user.CreateUserRequest;

import java.util.UUID;

public interface CreateUserUseCase {
    UUID execute(CreateUserRequest userData);
}
