package br.com.okto.modules.user.application.port.in.usecase;

import java.util.UUID;

public interface DeleteUserUseCase {
    void execute(UUID id);
}
