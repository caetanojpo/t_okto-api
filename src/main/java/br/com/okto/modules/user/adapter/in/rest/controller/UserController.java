package br.com.okto.modules.user.adapter.in.rest.controller;

import br.com.okto.modules.user.application.dto.user.CreateUserRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserBasicInfoRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserPasswordRequest;
import br.com.okto.modules.user.application.dto.user.UpdateUserRoleRequest;
import br.com.okto.modules.user.application.dto.user.UserResponse;
import br.com.okto.modules.user.application.port.in.user.CreateUserUseCase;
import br.com.okto.modules.user.application.port.in.user.FindUserUseCase;
import br.com.okto.modules.user.application.port.in.user.UpdateUserUseCase;
import br.com.okto.shared.dto.ApiResponse;
import br.com.okto.shared.dto.PageInfo;
import br.com.okto.shared.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private final CreateUserUseCase create;
    private final FindUserUseCase find;
    private final UpdateUserUseCase update;

    @Inject
    public UserController(CreateUserUseCase create, FindUserUseCase find, UpdateUserUseCase update) {
        this.create = create;
        this.find = find;
        this.update = update;
    }

    @POST
    @Transactional
    public Response createUser(@Valid CreateUserRequest userData){
        UUID userId = create.execute(userData);
        return Response.status(Response.Status.CREATED)
                .entity(userId)
                .build();
    }

    @GET
    public Response findAllUsers(){
        var users = find.executeAll();
        PageInfo<UserResponse> meta = new PageInfo<>(
                users,
                users.size(),
                0,
                1,
               1
        );
        return Response.status(Response.Status.OK)
                .entity(meta)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id){
        var user = find.executeById(id);
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success(user))
                .build();
    }

    @GET
    @Path("/email/{email}")
    public Response findById(@PathParam("email") String email){
        var user = find.executeByEmail(email);
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success(user))
                .build();
    }

    @PATCH
    @Path("/update-password/{id}")
    public Response updatePassword(@Valid UpdateUserPasswordRequest newUserData, @PathParam("id") UUID id){
        update.executeChangePassword(newUserData, id);

        return Response.status(Response.Status.NO_CONTENT)
                .entity("User password updated!")
                .build();
    }

    @PATCH
    @Path("/update-info/{id}")
    public Response updateInfo(@Valid UpdateUserBasicInfoRequest newUserData, @PathParam("id") UUID id){
        update.executeChangeBasicInfo(newUserData, id);

        return Response.status(Response.Status.NO_CONTENT)
                .entity("User basic info updated!")
                .build();
    }

    @PATCH
    @Path("/update-role/{id}")
    public Response updateRole(@Valid UpdateUserRoleRequest newUserData, @PathParam("id") UUID id){
        update.executeChangeUserRole(newUserData, id);

        return Response.status(Response.Status.NO_CONTENT)
                .entity("User role updated!")
                .build();
    }
}
