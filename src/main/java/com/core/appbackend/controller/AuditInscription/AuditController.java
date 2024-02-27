package com.core.appbackend.controller.AuditInscription;

import com.core.appbackend.beans.audit.AuditModelDTO;
import com.core.appbackend.playload.model.RevisionDetail;
import com.core.appbackend.playload.response.AuditsResponse;
import com.core.appbackend.service.AuditInscription.AuditInscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuditController {
    @Autowired
    AuditInscriptionServiceImpl auditInscriptionService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/audit_inscriptions")
    public ResponseEntity<?> getAllAudit(){
        try{
            List<AuditModelDTO> Audits = auditInscriptionService.findAll();
            if(Audits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new AuditsResponse(Audits, HttpStatus.OK), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/RevisionTypeDetails")
    public ResponseEntity<List<?>> RevisionTypeDetails(){
        try{
            HashMap<String, Integer> revisionTypeDetails = auditInscriptionService.getRevisionTypeDetails();
            List<RevisionDetail> revisionDetailList = auditInscriptionService.listRevisionDetail(revisionTypeDetails);
            return new ResponseEntity<>(revisionDetailList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
