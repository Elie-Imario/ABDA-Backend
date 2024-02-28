package com.core.appbackend.controller.Inscription;

import com.core.appbackend.beans.Inscription;
import com.core.appbackend.playload.response.InscriptionResponse;
import com.core.appbackend.service.Inscription.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/inscriptions")
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


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/inscription")
    public ResponseEntity<?> createInscription(@RequestBody Inscription inscription){
        try{
            Inscription newInscription = inscriptionService.addInscription(new Inscription(
                    inscription.getMatricule(), inscription.getNom(), inscription.getDroitInscription()
            ));
            return new ResponseEntity<>(new InscriptionResponse(newInscription, HttpStatus.CREATED, "L'étudiant(e) a été inscrit(e) avec succès!"), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/inscriptions/{id}")
    public ResponseEntity<Inscription> getInscriptionById(@PathVariable("id") Long id){
        try{
            Inscription inscription = inscriptionService.findInscriptionById(id);
            return new ResponseEntity<>(inscription, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/inscriptions/{id}")
    public ResponseEntity<?> updateInscription(@PathVariable("id") Long id, @RequestBody Inscription inscription){
        try{
            Inscription fetchedInscription = inscriptionService.findInscriptionById(id);
            fetchedInscription.setMatricule(inscription.getMatricule());
            fetchedInscription.setNom(inscription.getNom());
            fetchedInscription.setDroitInscription(inscription.getDroitInscription());

            Inscription UpdatedInscrption = inscriptionService.updateInscription(fetchedInscription);
            return new ResponseEntity<>(new InscriptionResponse(UpdatedInscrption, HttpStatus.OK, "Les informations de l'étudiant(e) inscrit(e) ont été modifié(e)"), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/inscriptions/{id}")
    public ResponseEntity<?> deleteInscription(@PathVariable("id") Long id){
        try {
            inscriptionService.deleteInscriptionById(id);
            return new ResponseEntity<>(new InscriptionResponse(HttpStatus.NO_CONTENT, "L'inscription a été retiré avec succès"), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new InscriptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
