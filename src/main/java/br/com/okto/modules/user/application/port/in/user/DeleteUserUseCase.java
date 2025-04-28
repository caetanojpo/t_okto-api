package br.com.okto.modules.user.application.port.in.user;

import java.util.UUID;

public interface DeleteUserUseCase {
    void execute(UUID id);
}
