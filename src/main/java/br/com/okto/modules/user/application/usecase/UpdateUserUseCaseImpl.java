package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.application.dto.user.UpdateUserBasicInfoRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserPasswordRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserRoleRequest;
import br.com.okto.modules.user.application.port.in.user.UpdateUserUseCase;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.modules.user.domain.enums.UserRole;
import br.com.okto.modules.user.domain.model.User;
import br.com.okto.shared.exception.EntityNotFoundException;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

import java.util.Date;
import java.util.UUID;

@Singleton
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository repository;

    public UpdateUserUseCaseImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public void executeChangePassword(UpdateUserPasswordRequest userData, UUID userId) {
        var existingUser = repository.findUserById(userId);

        if(existingUser == null || !existingUser.isActive()){
            throw new EntityNotFoundException("USER", userId.toString(), "id");
        }

        String newUserPassword = userData.password();

        existingUser.setHashedPassword(newUserPassword);
        existingUser.setUpdatedAt(new Date());

        repository.updateUser(existingUser);
    }

    @Override
    public void executeChangeBasicInfo(UpdateUserBasicInfoRequest userData, UUID userId) {
        var existingUser = repository.findUserById(userId);

        if(existingUser == null || !existingUser.isActive()){
            throw new EntityNotFoundException("USER", userId.toString(), "id");
        }

        existingUser.setName(validateForEmptyValue(userData.name(), existingUser.getName()));
        existingUser.setEmail(validateForEmptyValue(userData.email(), existingUser.getEmail()));
        existingUser.setUpdatedAt(new Date());

        repository.updateUser(existingUser);
    }

    @Override
    public void executeChangeUserRole(UpdateUserRoleRequest userData, UUID userId) {
        var existingUser = repository.findUserById(userId);

        if(existingUser == null || !existingUser.isActive()){
            throw new EntityNotFoundException("USER", userId.toString(), "id");
        }

        UserRole newUserRole = userData.role();

        existingUser.setRole(newUserRole);
        existingUser.setUpdatedAt(new Date());

        repository.updateUser(existingUser);
    }

    private String validateForEmptyValue(String newValue, String currentValue) {
        return newValue != null && !newValue.trim().isEmpty() ? newValue : currentValue;
    }
}
