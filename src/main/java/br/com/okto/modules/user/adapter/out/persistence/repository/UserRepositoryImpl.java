package br.com.okto.modules.user.adapter.out.persistence.repository;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.port.out.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import br.com.okto.shared.exception.DatabaseException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserRepositoryImpl
        implements UserRepository, PanacheRepositoryBase<UserEntity, UUID> {

    @Override
    @Transactional
    public void saveUser(UserEntity userToBeSaved) {
        try {
            persist(userToBeSaved);
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "saveUser", error);
        }
    }

    @Override
    @Transactional
    public UserEntity findUserById(UUID userId) {
        try {
            return findById(userId);
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "findUserById",  error);
        }
    }

    @Override
    @Transactional
    public UserEntity findUserByEmail(String userEmail) {
        try {
            return find("email", userEmail).firstResult();
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "findUserByEmail", error);
        }
    }

    @Override
    @Transactional
    public List<UserEntity> findAllUsers() {
        try {
            return listAll();
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "findAllUsers", error);
        }
    }

    @Override
    @Transactional
    public void updateUser(UserEntity userToBeUpdated) {
        try {
            getEntityManager().merge(userToBeUpdated);
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "updateUser", error);
        }
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        try {
            UserEntity entity = findById(userId);
            entity.setActive(false);
            persist(entity);
        } catch (Exception error) {
            throw new DatabaseException(UserRepository.class.getSimpleName(), "deleteUser", error);
        }
    }
}
