package br.com.okto.modules.user.application.port.in.usecase;

import br.com.okto.modules.user.application.dto.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface FindUserUseCase {
    UserResponse executeById(UUID id);
    UserResponse executeByEmail(String email);
    List<UserResponse> executeAll();
}
