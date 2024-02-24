package com.core.appbackend.beans;

import com.core.appbackend.service.AuditRevisionListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table(name = "revision_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RevisionEntity(AuditRevisionListener.class)

public class AuditRevisionEntity extends DefaultRevisionEntity {
    @Column(name="responsable", nullable = false)
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
