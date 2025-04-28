package br.com.okto.modules.user.application.port.in.user;

import br.com.okto.modules.user.domain.model.User;

public interface UpdateUserUseCase {
    void execute(User userData);
}
