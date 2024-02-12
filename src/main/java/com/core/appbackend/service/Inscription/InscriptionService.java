package com.core.appbackend.service.Inscription;

import com.core.appbackend.beans.Inscription;
import com.core.appbackend.repository.Inscription.InscriptionRepositoryInterace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {
    @Autowired
    InscriptionRepositoryInterace inscriptionRepository;

    public Iterable<Inscription> findAllInscription(){
        return inscriptionRepository.findAll(Sort.by(Sort.Direction.DESC,"inscriptionId"));
    }

    public Inscription findInscriptionById(Long id){
        return inscriptionRepository.findById(id).orElseThrow();
    }

    public Inscription addInscription(Inscription inscription){
        return inscriptionRepository.save(inscription);
    }

    public Inscription updateInscription(Inscription inscription){
        return inscriptionRepository.save(inscription);
    }
    public void deleteInscriptionById(Long id){
        inscriptionRepository.deleteById(id);
    }
}
