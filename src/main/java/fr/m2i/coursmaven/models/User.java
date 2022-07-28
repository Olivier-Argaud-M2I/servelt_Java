package fr.m2i.coursmaven.models;


import java.beans.JavaBean;

@JavaBean
public class User {

    private String nom;
    private String prenom;
    private String mail;

    private Integer age;

    private String role;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public User(String nom, String prenom, String mail, Integer age, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.age = age;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
