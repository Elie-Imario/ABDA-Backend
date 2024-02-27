package com.core.appbackend.service.AuditInscription;

import com.core.appbackend.beans.Inscription;
import com.core.appbackend.beans.audit.AuditModelDTO;
import com.core.appbackend.playload.model.RevisionDetail;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AuditInscriptionServiceImpl {
    @Autowired
    private AuditReader auditReader;

    private AuditQuery auditQueryForRevTable(){
        return auditReader.createQuery()
                .forRevisionsOfEntity(Inscription.class, false,true)
                .addProjection(AuditEntity.revisionNumber()) // [0] Revision_info (:id)
                .addProjection(AuditEntity.revisionType()) // [1] Revision_info_type (:action_type)
                .addProjection(AuditEntity.revisionProperty("timestamp")) // [2] Revision_createdAt (:createdAt)
                .addProjection(AuditEntity.id()) // [3] inscriptionId
                .addProjection(AuditEntity.property("matricule")) // [4] matricule
                .addProjection(AuditEntity.property("nom")) // [5] nom
                .addProjection(AuditEntity.property("droitInscription")) // [6] droitInscription
                .addProjection(AuditEntity.revisionProperty("userName")) // [7] responsable
                .addOrder(AuditEntity.revisionProperty("timestamp").desc());
    }


    public List<AuditModelDTO> findAll(){
        List<AuditQuery> auditQueries = auditQueryForRevTable().getResultList();
        List<AuditModelDTO> audits = new ArrayList<>();
            try{
                AuditModelDTO auditModelDTO = new AuditModelDTO();
                for(Object auditQueryObject : auditQueries){
                    Object[] auditRowArray = (Object[]) auditQueryObject;
                    if(auditRowArray[1].toString().equals("ADD")){
                        auditModelDTO = new AuditModelDTO(
                                Long.parseLong(auditRowArray[0].toString()),
                                Long.parseLong(auditRowArray[3].toString()),
                                auditRowArray[5].toString(),
                                auditRowArray[4].toString(),
                                null,
                                Integer.valueOf(auditRowArray[6].toString()),
                                new Timestamp(Long.parseLong(auditRowArray[2].toString())),
                                auditRowArray[7].toString(),
                                auditRowArray[1].toString()
                        );
                    } else if (auditRowArray[1].toString().equals("DEL")) {
                        auditModelDTO = new AuditModelDTO(
                                Long.parseLong(auditRowArray[0].toString()),
                                Long.parseLong(auditRowArray[3].toString()),
                                auditRowArray[5].toString(),
                                auditRowArray[4].toString(),
                                Integer.valueOf(auditRowArray[6].toString()),
                                null,
                                new Timestamp(Long.parseLong(auditRowArray[2].toString())),
                                auditRowArray[7].toString(),
                                auditRowArray[1].toString()
                        );
                    }else{
                        auditModelDTO = new AuditModelDTO(
                                Long.parseLong(auditRowArray[0].toString()),
                                Long.parseLong(auditRowArray[3].toString()),
                                auditRowArray[5].toString(),
                                auditRowArray[4].toString(),
                                getOldDroit(Integer.valueOf(auditRowArray[3].toString()), Long.parseLong(auditRowArray[0].toString())),
                                Integer.valueOf(auditRowArray[6].toString()),
                                new Timestamp(Long.parseLong(auditRowArray[2].toString())),
                                auditRowArray[7].toString(),
                                auditRowArray[1].toString()
                        );
                    }
                    audits.add(auditModelDTO);
                }

            }catch (Exception e){
                e.printStackTrace();
            }


        return audits;
    }

    private int getOldDroit(int inscriptionId, Long currentRev){
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Inscription.class, true,true)
                .addProjection(AuditEntity.property("droitInscription"))
                .add(AuditEntity.id().eq(inscriptionId))
                .add(AuditEntity.revisionNumber().lt(currentRev))
                .addOrder(AuditEntity.revisionNumber().desc())
                .setMaxResults(1);

        return Integer.valueOf(auditQuery.getSingleResult().toString());
    }

    public HashMap<String, Integer> getRevisionTypeDetails(){
        List<?> revisionTypes = auditReader.createQuery()
                .forRevisionsOfEntity(Inscription.class, false,true)
                .addProjection(AuditEntity.revisionType())
                .getResultList();
        String[] revisionTypesArray = new String[revisionTypes.size()];

        for (int i = 0; i < revisionTypes.size(); i++) {
            revisionTypesArray[i] =  revisionTypes.get(i).toString();
        }

        return CountRevisionType(revisionTypesArray);
    }

    public List<RevisionDetail> listRevisionDetail(HashMap<String, Integer> revisionDetails){
        List<RevisionDetail> revisionDetailList = new ArrayList<>();
        RevisionDetail revisionDetail = new RevisionDetail();
        if (!revisionDetails.isEmpty()){
            for (HashMap.Entry<String, Integer> entry : revisionDetails.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                revisionDetail = new RevisionDetail(key, value);
                revisionDetailList.add(revisionDetail);
            }
        }

        return revisionDetailList;
    }


    private HashMap<String, Integer> CountRevisionType(String[] revisionTypes){
        HashMap<String, Integer> countRevision = new HashMap<String, Integer>();
        for (String revisionType : revisionTypes) {
            if(countRevision.containsKey(revisionType)){
                countRevision.put(revisionType, countRevision.get(revisionType) + 1);
            }
            else {
                countRevision.put(revisionType.toString(), 1);
            }
        }

        return countRevision;
    }
}
