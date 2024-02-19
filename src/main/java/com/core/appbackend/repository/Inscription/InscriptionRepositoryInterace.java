package com.core.appbackend.repository.Inscription;

import com.core.appbackend.beans.Inscription;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface InscriptionRepositoryInterace extends CrudRepository<Inscription, Long> {
    Iterable<Inscription> findAll(Sort inscriptionId);
}
