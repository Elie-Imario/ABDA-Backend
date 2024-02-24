package com.core.appbackend.beans.audit;

import jakarta.annotation.Nullable;

import java.sql.Timestamp;

public class AuditModelDTO {
    private Long auditId;
    private Long inscriptionId;
    private String nom;
    private String matricule;

    @Nullable
    private Integer oldDroit;
    private Integer newDroit;
    private Timestamp createdAt;

    private String responsable;

    private String actionType;
    public AuditModelDTO() {
    }

    public AuditModelDTO(Long auditId, Long inscriptionId, String nom, String matricule, Integer oldDroit, Integer newDroit, Timestamp createdAt, String responsable, String actionType) {
        this.auditId = auditId;
        this.inscriptionId = inscriptionId;
        this.nom = nom;
        this.matricule = matricule;
        this.oldDroit = oldDroit;
        this.newDroit = newDroit;
        this.createdAt = createdAt;
        this.responsable = responsable;
        this.actionType = actionType;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Long inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Nullable
    public Integer getOldDroit() {
        return oldDroit;
    }

    public void setOldDroit(@Nullable Integer oldDroit) {
        this.oldDroit = oldDroit;
    }

    public Integer getNewDroit() {
        return newDroit;
    }

    public void setNewDroit(Integer newDroit) {
        this.newDroit = newDroit;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
