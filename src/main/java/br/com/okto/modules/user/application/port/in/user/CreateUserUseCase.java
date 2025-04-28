package br.com.okto.modules.user.application.port.in.user;

import br.com.okto.modules.user.domain.model.User;

public interface CreateUserUseCase {
    void execute(User userData);
}
