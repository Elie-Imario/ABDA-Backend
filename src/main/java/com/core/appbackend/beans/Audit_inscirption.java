package com.core.appbackend.beans;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "audit_inscription")
public class Audit_inscirption {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_audit_inscription_key_generator")
    @TableGenerator(name = "id_audit_inscription_key_generator",
            table = "pk_audit_inscription",
            pkColumnName = "name",
            valueColumnName = "value",
            allocationSize = 1)
    @Column(name = "audit_id")
    private Long auditId;
    private String matricule;
    private String nom;
    private Long oldDroitInscription;
    private Long newDroitInscription;
    private Date EditedAt;
    private String Utilisateur;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
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

    public Long getOldDroitInscription() {
        return oldDroitInscription;
    }

    public void setOldDroitInscription(Long oldDroitInscription) {
        this.oldDroitInscription = oldDroitInscription;
    }

    public Long getNewDroitInscription() {
        return newDroitInscription;
    }

    public void setNewDroitInscription(Long newDroitInscription) {
        this.newDroitInscription = newDroitInscription;
    }

    public Date getEditedAt() {
        return EditedAt;
    }

    public void setEditedAt(Date editedAt) {
        EditedAt = editedAt;
    }

    public String getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        Utilisateur = utilisateur;
    }
}
