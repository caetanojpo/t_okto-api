package br.com.okto.shared.mapper;

import br.com.okto.adapter.outboud.persistence.entity.UserEntity;
import br.com.okto.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", source = "hashedPassword")
    User toDomain(UserEntity entity);

    @Mapping(target = "hashedPassword", source = "password")
    UserEntity toEntity(User domain);
}
