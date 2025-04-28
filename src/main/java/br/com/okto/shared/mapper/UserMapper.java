package br.com.okto.shared.mapper;

import br.com.okto.modules.user.adapter.outboud.persistence.entity.UserEntity;
import br.com.okto.modules.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}
