package fr.m2i.coursmaven.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.m2i.coursmaven.models.Tache;

@Path("/Tache")
public class TacheResource {
    private final List<Tache> listTache = new ArrayList<>();


    public TacheResource() {
        this.listTache.add(new Tache("Tache1","preparer a bouffer",LocalDateTime.now()));
        this.listTache.add(new Tache("Tache2","bouffer",LocalDateTime.now()));
        this.listTache.add(new Tache("Tache3","faire la sieste",LocalDateTime.now()));
        this.listTache.add(new Tache("Tache4","reprendre les cours",LocalDateTime.now()));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tache get(@PathParam("id")int id) {
//		public Tache get(@PathParam ("id: [0-9]")int id) {
        return this.listTache.get(id);
    }
    @GET
    @Path("/byName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tache getByName(@PathParam("name")String name) {
//		public Tache get(@PathParam ("id: [0-9]")int id) {
        return this.listTache.stream().filter(tache -> tache.getNom().equals(name)).collect(Collectors.toList()).get(0);
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tache> getAll() {
        return this.listTache;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("nom") String nom, @FormParam("description") String description) {
        this.listTache.add(new Tache(nom,description,LocalDateTime.now()));
        System.out.print(nom);
        System.out.print(this.listTache.size());
    }

}
