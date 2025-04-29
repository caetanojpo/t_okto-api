package br.com.okto.modules.user.application.dto.user;

import br.com.okto.modules.user.domain.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRoleRequest(
        @NotBlank(message = "New role is required")
        UserRole role
) {
}
