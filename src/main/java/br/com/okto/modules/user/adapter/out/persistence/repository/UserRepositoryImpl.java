package br.com.okto.modules.user.adapter.out.persistence.repository;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.port.out.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import br.com.okto.shared.exception.DatabaseException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserRepositoryImpl
        implements UserRepository, PanacheRepositoryBase<UserEntity, UUID> {

    @Override
    public void saveUser(UserEntity userToBeSaved) {
        try {
            persist(userToBeSaved);
        } catch (Exception error) {
            throw new DatabaseException("saveUser", "USER", error);
        }
    }

    @Override
    public UserEntity findUserById(UUID userId) {
        try {
            return findById(userId);
        } catch (Exception error) {
            throw new DatabaseException("findUserById", "USER", error);
        }
    }

    @Override
    public UserEntity findUserByEmail(String userEmail) {
        try {
            return find("email", userEmail).firstResult();
        } catch (Exception error) {
            throw new DatabaseException("findUserByEmail", "USER", error);
        }
    }

    @Override
    public List<UserEntity> findAllUsers() {
        try {
            return listAll();
        } catch (Exception error) {
            throw new DatabaseException("findAllUsers", "USER", error);
        }
    }

    @Override
    public void updateUser(UserEntity userToBeUpdated) {
        try {
            persist(userToBeUpdated);
        } catch (Exception error) {
            throw new DatabaseException("updateUser", "USER", error);
        }
    }

    @Override
    public void deleteUser(UUID userId) {
        try {
            UserEntity entity = findById(userId);
            entity.setActive(false);
            persist(entity);
        } catch (Exception error) {
            throw new DatabaseException("deleteUser", "USER", error);
        }
    }
}
