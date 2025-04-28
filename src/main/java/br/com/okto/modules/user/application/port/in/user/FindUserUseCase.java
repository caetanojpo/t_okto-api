package br.com.okto.modules.user.application.port.in.user;

import br.com.okto.modules.user.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface FindUserUseCase {
    User executeById(UUID id);
    User executeByEmail(String email);
    List<User> executeAll();
}
