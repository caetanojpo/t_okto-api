package br.com.okto.modules.user.application.usecase;

import br.com.okto.modules.user.application.dto.user.UpdateUserBasicInfoRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserPasswordRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserRoleRequest;
import br.com.okto.modules.user.application.port.in.usecase.UpdateUserUseCase;
import br.com.okto.modules.user.application.port.out.repository.UserRepository;
import br.com.okto.modules.user.application.port.out.security.EncryptPassword;
import br.com.okto.modules.user.domain.enums.UserRole;
import br.com.okto.shared.exception.EntityNotFoundException;
import jakarta.inject.Singleton;

import java.util.Date;
import java.util.UUID;

@Singleton
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository repository;
    private final EncryptPassword encryptService;

    public UpdateUserUseCaseImpl(UserRepository repository, EncryptPassword encryptService){
        this.repository = repository;
        this.encryptService = encryptService;
    }

    @Override
    public void executeChangePassword(UpdateUserPasswordRequest userData, UUID userId) {
        var existingUser = repository.findUserById(userId);

        if(existingUser == null || !existingUser.isActive()){
            throw new EntityNotFoundException("USER", userId.toString(), "id");
        }

        String hashedPassword = encryptService.hash(userData.password());

        existingUser.setHashedPassword(hashedPassword);
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
