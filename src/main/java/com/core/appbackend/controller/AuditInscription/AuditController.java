package com.core.appbackend.controller.AuditInscription;

import com.core.appbackend.beans.audit.AuditModelDTO;
import com.core.appbackend.service.AuditInscription.AuditInscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuditController {
    @Autowired
    AuditInscriptionServiceImpl auditInscriptionService;

    @GetMapping("/audit_inscriptions")
    public ResponseEntity<List<?>> getAllAudit(){
        try{
            List<AuditModelDTO> Audits = auditInscriptionService.findAll();
            if(Audits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Audits, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/RevisionTypeDetails")
    public ResponseEntity<HashMap<String, Integer>> RevisionTypeDetails(){
        try{
            HashMap<String, Integer> actionType = auditInscriptionService.getRevisionTypeDetails();
            return new ResponseEntity<>(actionType, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
