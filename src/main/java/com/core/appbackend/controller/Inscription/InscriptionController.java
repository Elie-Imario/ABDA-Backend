package com.core.appbackend.controller.Inscription;

import com.core.appbackend.beans.Inscription;
import com.core.appbackend.service.Inscription.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    @GetMapping
    public ResponseEntity<List<Inscription>>  getAllInscription(){
        try{
            List<Inscription> inscriptions = new ArrayList<Inscription>();
            inscriptionService.findAllInscription().forEach(inscription -> {
                inscriptions.add(inscription);
            });
            if(inscriptions.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(inscriptions, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Inscription> createInscription(@RequestBody Inscription inscription){
        try{
            Inscription newInscription = inscriptionService.addInscription(new Inscription(
                    inscription.getMatricule(), inscription.getNom(), inscription.getDroitInscription()
            ));
            return new ResponseEntity<>(newInscription, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
