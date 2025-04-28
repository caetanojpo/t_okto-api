package br.com.okto.modules.user.application.dto.user;

import br.com.okto.modules.user.domain.enums.UserRole;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        UserRole role
) { }
