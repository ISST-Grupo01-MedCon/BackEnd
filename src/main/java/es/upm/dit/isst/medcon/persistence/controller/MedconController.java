package es.upm.dit.isst.medcon.persistence.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.medcon.persistence.repository.MedconRepository;
import es.upm.dit.isst.medcon.persistence.model.Consulta;
import es.upm.dit.isst.medcon.persistence.model.Medico;

@RestController
public class MedconController {
    private final MedconRepository medconRepository;
    public static final Logger log = LoggerFactory.getLogger(MedconController.class);
    public MedconController(MedconRepository t) {
        this.medconRepository = t;
    }
    @GetMapping("/consultas")
    List<Consulta> readAll(){
        return (List<Consulta>) medconRepository.findAll();
    }
    @GetMapping("/consultas/{id}")
    ResponseEntity<Consulta> read(@PathVariable String id){
        return medconRepository.findById(id).map(consulta ->
            ResponseEntity.ok().body(consulta)
        ).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/consultas/{id}")
    ResponseEntity<Consulta> update(@PathVariable String id) {
        return medconRepository.findById(id).map(consulta ->{
            consulta.setDescartado(true);
            return ResponseEntity.ok().body(consulta);
        }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
    //@PostMapping("/consultas/{id}")Para implementar el texto de la consulta ??
}
