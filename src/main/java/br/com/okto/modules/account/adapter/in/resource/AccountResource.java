package br.com.okto.modules.account.adapter.in.resource;

import br.com.okto.shared.dto.ApiResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @POST
    public Response createUserAccount(){
                return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("getUserAccountById called"))
                .build();
    }

    @GET
    public Response getAllUserAccounts(){
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("getAllUserAccounts called"))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getUserAccountById(@PathParam("id") UUID id){
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("getUserAccountById called"))
                .build();
    }

    @GET
    @Path("/user/{userId}")
    public Response getAllUserAccountsByUserId(@PathParam("userId") UUID userId){
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("getAllUserAccountsByUserId called"))
                .build();
    }

    @GET
    @Path("/family")
    public Response getFamilyAccount(){
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("getFamilyAccount called"))
                .build();
    }

    @PATCH
    @Path("/transaction/{id}")
    public Response doAccountTransaction(@PathParam("id") UUID id){
                return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("doAccountTransaction called"))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") UUID id){
        return Response.status(Response.Status.OK)
                .entity(ApiResponse.success("deleteAccount called"))
                .build();
    }
}
