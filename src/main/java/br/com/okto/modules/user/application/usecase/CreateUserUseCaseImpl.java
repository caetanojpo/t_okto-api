package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.dto.user.CreateUserRequest;
import br.com.okto.modules.user.application.port.in.user.CreateUserUseCase;
import br.com.okto.modules.user.application.port.in.user.FindUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.modules.user.domain.enums.UserRole;
import br.com.okto.shared.exception.ConflictException;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@ApplicationScoped
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository repository;
    private static final UserMapper mapper = UserMapper.INSTANCE;

    @Inject
    public CreateUserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID execute(CreateUserRequest userData) {

        UserEntity userToBeCreated = UserEntity.builder()
                .name(userData.name())
                .email(userData.email())
                .hashedPassword(userData.password())
                .isActive(true)
                .role(UserRole.USER)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        repository.saveUser(userToBeCreated);
        return userToBeCreated.getId();
    }
}
