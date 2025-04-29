package br.com.okto.modules.user.application.port.out.repository;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    void saveUser(UserEntity userToBeSaved);
    UserEntity findUserById(UUID userId);
    UserEntity findUserByEmail(String userEmail);
    List<UserEntity> findAllUsers();
    void updateUser(UserEntity userToBeUpdated);
    void deleteUser(UUID userId);
}
