package com.core.appbackend.repository.AuditInscription;

import com.core.appbackend.beans.Audit_inscirption;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface AuditInscriptionRepositoryInterface extends CrudRepository<Audit_inscirption, Long> {
    Iterable<Audit_inscirption> findAll(Sort auditId);
}
