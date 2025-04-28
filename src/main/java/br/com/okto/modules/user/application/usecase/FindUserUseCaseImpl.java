package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.dto.user.UserResponse;
import br.com.okto.modules.user.application.port.in.user.FindUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.shared.exception.EntityNotFoundException;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class FindUserUseCaseImpl implements FindUserUseCase {
    private final UserRepository repository;
    private static final UserMapper mapper = UserMapper.INSTANCE;

    @Inject
    public FindUserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse executeById(UUID id) {
        UserEntity foundUser = repository.findUserById(id);

        if (foundUser == null) {
            throw new EntityNotFoundException("user");
        }

        return mapper.toResponse(foundUser);
    }

    @Override
    public UserResponse executeByEmail(String email) {
        UserEntity foundUser = repository.findUserByEmail(email);

        if (foundUser == null) {
            throw new EntityNotFoundException("user");
        }

        return mapper.toResponse(foundUser);
    }

    @Override
    public List<UserResponse> executeAll() {
        List<UserEntity> foundUsers = repository.findAllUsers();

        return foundUsers.stream().map(mapper::toResponse).toList();
    }
}
