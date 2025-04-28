package br.com.okto.modules.user.adapter.outboud.persistence.repository;

import br.com.okto.modules.user.adapter.outboud.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.port.out.UserRepository;
import br.com.okto.shared.exception.EntityNotFoundException;
import br.com.okto.shared.exception.DatabaseException;
import br.com.okto.modules.user.domain.model.User;
import br.com.okto.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryPanache panacheRepository;
    private static final UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public void saveUser(User userToBeSaved) {
        try {
            var mappedUser = mapper.toEntity(userToBeSaved);
            panacheRepository.persist(mappedUser);
        } catch (Exception error) {
            throw new DatabaseException("saveUser", error);
        }
    }

    @Override
    public User findUserById(UUID userId) {
        try {
            UserEntity foundUser = panacheRepository.findById(userId);

            if (foundUser == null) {
                throw new EntityNotFoundException("user");
            }

            return mapper.toDomain(foundUser);
        } catch (EntityNotFoundException entityNotFoundError) {
            throw entityNotFoundError;
        } catch (Exception error) {
            throw new DatabaseException("findUserById", error);
        }
    }

    @Override
    public User findUserByEmail(String userEmail) {
        try {
            UserEntity foundUser = panacheRepository
                    .find("email", userEmail)
                    .firstResult();

            if (foundUser == null) {
                throw new EntityNotFoundException("user");
            }

            return mapper.toDomain(foundUser);
        } catch (EntityNotFoundException entityNotFoundError) {
            throw entityNotFoundError;
        } catch (Exception error) {
            throw new DatabaseException("findUserById", error);
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            List<UserEntity> foundUsers = panacheRepository.findAll().stream().toList();

            if (foundUsers.isEmpty()) {
                throw new EntityNotFoundException("user");
            }

            return foundUsers.stream().map(mapper::toDomain).toList();
        } catch (EntityNotFoundException entityNotFoundError) {
            throw entityNotFoundError;
        } catch (Exception error) {
            throw new DatabaseException("findUserById", error);
        }
    }

    @Override
    public void updateUser(User userToBeUpdated) {
        try {
            UserEntity mappedUser = mapper.toEntity(userToBeUpdated);
            panacheRepository.persist(mappedUser);
        } catch (Exception error) {
            throw new DatabaseException("updateUser", error);
        }
    }

    @Override
    public void deleteUser(UUID userId) {
        try {
            UserEntity entity = panacheRepository.findById(userId);
            entity.setActive(false);
            panacheRepository.persist(entity);
        } catch (Exception error) {
            throw new DatabaseException("deleteUser", error);
        }
    }
}
