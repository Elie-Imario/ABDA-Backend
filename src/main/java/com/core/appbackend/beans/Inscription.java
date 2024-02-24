package com.core.appbackend.beans;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.Objects;

@Entity(name = "inscription")
@Audited
public class Inscription {
    @Id
    @NotAudited
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return Objects.equals(inscriptionId, that.inscriptionId) && Objects.equals(matricule, that.matricule) && Objects.equals(nom, that.nom) && Objects.equals(droitInscription, that.droitInscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inscriptionId, matricule, nom, droitInscription);
    }
}
