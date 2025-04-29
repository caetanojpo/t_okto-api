package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.application.port.in.user.DeleteUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.shared.exception.EntityNotFoundException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private final UserRepository repository;

    @Inject
    public DeleteUserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UUID id) {
        var existingUser = repository.findUserById(id);

        if(existingUser == null || !existingUser.isActive()){
            throw new EntityNotFoundException("USER", id.toString(), "id");
        }

        repository.deleteUser(id);
    }
}
