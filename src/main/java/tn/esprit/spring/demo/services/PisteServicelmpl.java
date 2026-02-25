package tn.esprit.spring.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.demo.entity.Piste;
import tn.esprit.spring.demo.repositories.PisteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PisteServicelmpl implements IPisteService {
    @Autowired
    private PisteRepository pisteRepository;

    @Scheduled(cron = "*/2 * * * * *" )
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }
    @Override
    public Piste addOrUpdatePiste(Piste piste) {
        log.info("piste"+ piste.toString());
        log.debug("DS1..............");
        log.debug("DS2");
        piste.setNamePiste("abc");
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Piste Piste) {
        pisteRepository.delete(Piste);

    }


    public Optional<Piste> retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste);
    }

}
