package com.aquileslopes.client;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/client")
public class ClientResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> get(){
        return Client.listAll();
    }

    @GET
    @Path("/findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Client findById(@QueryParam("id") long id){
        return Client.findById(id);
    }

    @DELETE
    @Path("/deleteById")
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteById(@QueryParam("id") long id){
        if(Client.deleteById(id)){
            return "Client " + id + " removed.";
        }else {
            return "Erro";
        }
    }

    @POST
    @Path("/new")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newClient(Client client){
        client.id = null;
        client.persist();

        return Response.status(Status.CREATED).entity(client).build();
    }
}
