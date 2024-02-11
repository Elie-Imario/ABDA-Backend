package com.core.appbackend.controller.AuditInscription;

import com.core.appbackend.beans.Audit_inscirption;
import com.core.appbackend.service.AuditInscription.AuditInscripionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuditInterfaceController {
    @Autowired
    AuditInscripionService auditInscripionService;

    @GetMapping("/audit_inscriptions")
    public ResponseEntity<List<Audit_inscirption>> getAllAudit(){
        try{
            List<Audit_inscirption> Audits = new ArrayList<>();
            auditInscripionService.findAllAudit().forEach(auditInscirption -> Audits.add(auditInscirption));
            if(Audits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Audits, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
