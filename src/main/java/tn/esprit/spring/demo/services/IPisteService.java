package tn.esprit.spring.demo.services;

import tn.esprit.spring.demo.entity.Piste;

import java.util.List;
import java.util.Optional;

public interface IPisteService {
    Piste addOrUpdatePiste(Piste piste);
    void removePiste(Piste piste);
    List<Piste> retrieveAllPistes();
    Optional<Piste> retrievePiste(Long numPiste);
}

