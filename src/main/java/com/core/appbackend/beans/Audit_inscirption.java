package com.core.appbackend.beans;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "audit_inscription")
public class Audit_inscirption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    private String actionType;
    private String matricule;
    private String nom;
    private Long oldDroitInscription;
    private Long newDroitInscription;
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime editedAt;
    private String utilisateur;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(Date editedAt) {
        editedAt = editedAt;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        utilisateur = utilisateur;
    }
}
