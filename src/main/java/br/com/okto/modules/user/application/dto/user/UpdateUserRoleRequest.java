package br.com.okto.modules.user.application.dto.user;

import br.com.okto.modules.user.domain.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRoleRequest(
        @NotNull(message = "New role is required")
        UserRole role
) {
}
