package br.com.okto.adapter.outboud.persistence.repository;

import br.com.okto.domain.model.User;
import br.com.okto.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryPanache panacheRepository;

    public UserRepositoryImpl(UserRepositoryPanache panacheRepository){
        this.panacheRepository = panacheRepository;
    }

    @Override
    public UUID saveUser(User userToBeSaved) {
        return null;
    }

    @Override
    public User findUserById(UUID userId) {
        return null;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User userToBeUpdated, UUID userId) {

    }

    @Override
    public void deleteUser(UUID userId) {

    }
}
