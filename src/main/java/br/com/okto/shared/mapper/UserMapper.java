package br.com.okto.shared.mapper;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import br.com.okto.modules.user.application.dto.user.CreateUserRequest;
import br.com.okto.modules.user.application.dto.user.UserResponse;
import br.com.okto.modules.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);

    UserResponse toResponse(User domain);
}
