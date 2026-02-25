package tn.esprit.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.demo.entity.*;
import tn.esprit.spring.demo.services.IPisteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/piste")
public class PisteController {
    private int length;
    private int slope;
    @Autowired
    IPisteService pisteservice;
    @GetMapping
    public String getRoot() {
        return "Welcome to the SkyStation API";
    }

    @PostMapping(value = "/addOrUpdatePiste")
    @ResponseBody
    Piste addOrUpdatePiste(@RequestBody Piste piste){

        pisteservice.addOrUpdatePiste(piste);

        return piste;
    }

    @GetMapping("/findPisteById/{numPiste}")

    public Optional<Piste> findPisteById(@PathVariable Long numPiste){

        return pisteservice.retrievePiste(numPiste);
    }

    @GetMapping("/findAllPiste")
    public List<Piste> findAllPiste(){
        return pisteservice.retrieveAllPistes();
    }

    @DeleteMapping("/{numPiste}")
    public ResponseEntity<Void> deletePiste(@PathVariable Long numPiste) {
        Optional<Piste> piste = pisteservice.retrievePiste(numPiste); // get the Piste first
        if (piste.isPresent()) {
            pisteservice.removePiste(piste.orElse(null));               // delete it
            return ResponseEntity.noContent().build();     // 204 No Content
        } else {
            return ResponseEntity.notFound().build();      // 404 Not Found
        }
    }

    @PutMapping("/updatePiste")
    @ResponseBody
    public String updatePiste(@RequestBody Piste piste){
        pisteservice.addOrUpdatePiste(piste);
        return "updated";
    }



    //{
    //    "idPiste": 2,
    //    "namePiste": "Blue Run",
    //    "color": "BLUE",
    //    "length": 3000,
    //    "slope": 35
    //  },
    //  {
    //    "idPiste": 3,
    //    "namePiste": "Green Run",
    //    "color": "GREEN",
    //    "length": 1000,
    //    "slope": 15
    //  }

    //id_piste	color	length	name_piste	slope
    //http://localhost:8082/piste/addOrUpdatePiste
    //{
    //    "idPiste": 1,
    //    "namePiste": "Red Run",
    //    "color": "RED",
    //    "length": 2000,
    //    "slope": 45
    //  }
}
