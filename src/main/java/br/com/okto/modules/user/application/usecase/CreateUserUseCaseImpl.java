package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.application.port.in.user.CreateUserUseCase;
import br.com.okto.modules.user.application.port.in.user.FindUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.modules.user.domain.model.User;
import br.com.okto.shared.exception.ConflictException;


public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository repository;
    private final FindUserUseCase find;

    public CreateUserUseCaseImpl(UserRepository repository, FindUserUseCase find){
        this.repository = repository;
        this.find = find;
    }

    @Override
    public void execute(User userData) {
        User foundUser = find.executeByEmail(userData.getEmail());

        if(foundUser != null){
            throw new ConflictException("User", userData.getEmail());
        }

        userData.setActive(true);
        repository.saveUser(userData);
    }
}
