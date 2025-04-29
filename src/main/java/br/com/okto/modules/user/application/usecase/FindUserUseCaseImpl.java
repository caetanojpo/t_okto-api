package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.dto.user.UserResponse;
import br.com.okto.modules.user.application.port.in.user.FindUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.shared.exception.EntityNotFoundException;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class FindUserUseCaseImpl implements FindUserUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Inject
    public FindUserUseCaseImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponse executeById(UUID id) {
        UserEntity foundUser = repository.findUserById(id);

        if (foundUser == null) {
            throw new EntityNotFoundException("USER", id.toString(), "id");
        }

        return mapper.toResponse(foundUser);
    }

    @Override
    public UserResponse executeByEmail(String email) {
        UserEntity foundUser = repository.findUserByEmail(email);

        if (foundUser == null) {
            throw new EntityNotFoundException("USER", email, "email");
        }

        return mapper.toResponse(foundUser);
    }

    @Override
    public List<UserResponse> executeAll() {
        List<UserEntity> foundUsers = repository.findAllUsers();

        return foundUsers.stream().map(mapper::toResponse).toList();
    }
}
