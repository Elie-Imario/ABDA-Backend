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
    private String Nom;
    private Long droitInscription;

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
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Long getDroitInscription() {
        return droitInscription;
    }

    public void setDroitInscription(Long droitInscription) {
        this.droitInscription = droitInscription;
    }
}
