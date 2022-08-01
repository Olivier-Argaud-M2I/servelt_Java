package fr.m2i.coursmaven.services;

import fr.m2i.coursmaven.models.User;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/User")
public class UserResource {
    private final List<User> listUser = new ArrayList<>();


    public UserResource() {

        this.listUser.add(new User("Spence","Bud"));
        this.listUser.add(new User("Hill","Terence"));
        this.listUser.add(new User("Asimov","Isaac"));

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> get() {
        return this.listUser;
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User create(@Context UriInfo context, @FormParam("nom") String nom, @FormParam("prenom") String prenom) {


        User user = new User(nom,prenom);
        this.listUser.add(user);
        System.out.print(user);
        System.out.print(this.listUser.size());


//        URI location = context.getRequestUriBuilder().path(user.getNom()).build();
//        return Response.created(location).entity(user).build();


        return user;
    }


}