package br.com.okto.modules.user.application.port.in.user;

import br.com.okto.modules.user.application.dto.user.UpdateUserBasicInfoRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserPasswordRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserRoleRequest;
import br.com.okto.modules.user.domain.enums.UserRole;
import br.com.okto.modules.user.domain.model.User;

import java.util.UUID;

public interface UpdateUserUseCase {
    void executeChangePassword(UpdateUserPasswordRequest userData, UUID userId);
    void executeChangeBasicInfo(UpdateUserBasicInfoRequest userData, UUID userId);
    void executeChangeUserRole(UpdateUserRoleRequest userData, UUID userId);
}
