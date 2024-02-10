package com.core.appbackend.beans;

import jakarta.persistence.*;

@Entity(name = "inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_inscription_key_generator")
    @TableGenerator(name = "id_inscription_key_generator",
            table = "pk_inscription",
            pkColumnName = "name",
            valueColumnName = "value",
            allocationSize = 1)
    @Column(name = "inscription_id")
    private Long inscriptionId;
    private String matricule;
    private String nom;
    private Long droitInscription;

    public Inscription() {}

    public Inscription(String matricule, String nom, Long droitInscription) {
        this.matricule = matricule;
        this.nom = nom;
        this.droitInscription = droitInscription;
    }

    public Long getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Long inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getDroitInscription() {
        return droitInscription;
    }

    public void setDroitInscription(Long droitInscription) {
        this.droitInscription = droitInscription;
    }
}
