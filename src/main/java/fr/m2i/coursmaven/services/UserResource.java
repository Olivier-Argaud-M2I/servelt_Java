package fr.m2i.coursmaven.services;

import fr.m2i.coursmaven.models.User;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
;

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

//    @POST
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void create(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
//        this.listUser.add(new User(nom,prenom));
//        System.out.print(nom);
//        System.out.print(this.listUser.size());
//    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User update(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
        User user = new User(nom,prenom);
        this.listUser.add(user);
        System.out.print(user);
        System.out.print(this.listUser.size());
        return user;
    }


}