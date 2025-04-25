package br.com.okto.adapter.outboud.persistence.repository;

import br.com.okto.adapter.outboud.persistence.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public interface UserRepositoryPanache extends PanacheRepositoryBase<UserEntity, UUID> {
}
