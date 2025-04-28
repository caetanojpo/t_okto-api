package br.com.okto.modules.user.adapter.in.rest;

import br.com.okto.modules.user.application.dto.user.CreateUserRequest;
import br.com.okto.modules.user.application.port.in.user.CreateUserUseCase;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private final CreateUserUseCase create;
    private static final UserMapper mapper = UserMapper.INSTANCE;

    @Inject
    public UserController(CreateUserUseCase create) {
        this.create = create;
    }

    @POST
    @Transactional
    public Response createUser(@Valid CreateUserRequest userData){
        UUID userId = create.execute(userData);
        return Response.status(Response.Status.CREATED)
                .entity(userId)
                .build();
    }

}
