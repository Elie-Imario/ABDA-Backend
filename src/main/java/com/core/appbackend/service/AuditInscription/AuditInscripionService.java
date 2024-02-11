package com.core.appbackend.service.AuditInscription;

import com.core.appbackend.beans.Audit_inscirption;
import com.core.appbackend.repository.AuditInscription.AuditInscriptionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuditInscripionService {
    @Autowired
    AuditInscriptionRepositoryInterface auditInscriptionRepository;

    public Iterable<Audit_inscirption> findAllAudit(){
        return auditInscriptionRepository.findAll(Sort.by(Sort.Direction.DESC, "auditId"));
    }
}
