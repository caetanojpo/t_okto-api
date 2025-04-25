package br.com.okto.domain.repository;

import br.com.okto.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    UUID saveUser(User userToBeSaved);
    User findUserById(UUID userId);
    User findUserByEmail(String userEmail);
    List<User> findAllUsers();
    void updateUser(User userToBeUpdated, UUID userId);
    void deleteUser(UUID userId);
}
