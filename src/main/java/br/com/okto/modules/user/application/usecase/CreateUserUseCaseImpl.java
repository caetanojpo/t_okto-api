package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.dto.user.CreateUserRequest;
import br.com.okto.modules.user.application.port.in.usecase.CreateUserUseCase;
import br.com.okto.modules.user.application.port.out.repository.UserRepository;
import br.com.okto.modules.user.application.port.out.security.EncryptPassword;
import br.com.okto.modules.user.domain.enums.UserRole;
import br.com.okto.shared.exception.ConflictException;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Date;
import java.util.UUID;

@Singleton
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository repository;
    private final EncryptPassword encryptService;

    @Inject
    public CreateUserUseCaseImpl(UserRepository repository, UserMapper mapper, EncryptPassword encryptService) {
        this.repository = repository;
        this.encryptService = encryptService;
    }

    @Override
    public UUID execute(CreateUserRequest userData) {
        var existingUser = repository.findUserByEmail(userData.email());
        if (existingUser != null) {
            throw new ConflictException("USER", userData.email(), "email");
        }

        String hashedPassword = encryptService.hash(userData.password());

        UserEntity userToBeCreated = UserEntity.builder()
                .name(userData.name())
                .email(userData.email())
                .hashedPassword(hashedPassword)
                .isActive(true)
                .role(UserRole.USER)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        repository.saveUser(userToBeCreated);
        return userToBeCreated.getId();
    }
}
