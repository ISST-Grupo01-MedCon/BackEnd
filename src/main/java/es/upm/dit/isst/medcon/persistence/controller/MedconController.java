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
        this.medconRepository.save(new Consulta( 7 ,"30/3/2022", "Ramón","María Asunción Santamaría Galdón", "Consultas de prueba","A01", false));
        this.medconRepository.save(new Consulta( 8 ,"30/3/2022", "Ramón","Jesús Frayle Ardanuy", "Consultas de prueba","D03", false));
        this.medconRepository.save(new Consulta( 9 ,"30/3/2022", "Ramón","Víctor Abraham Villagrá González", "Consultas de prueba","H69", false));
        this.medconRepository.save(new Consulta( 10 ,"30/3/2022", "Ramón","Gabriel Huecas Toribio", "Consultas de prueba","X43", false));
        this.medconRepository.save(new Consulta( 11 ,"30/3/2022", "Ramón","María de la Nava Maroto García", "Consultas de prueba","B02", false));
        this.medconRepository.save(new Consulta( 13 ,"30/3/2022", "Ramón","Juan Carlos Yelmo García", "Consultas de prueba","G54", false));
        this.medconRepository.save(new Consulta( 2 ,"30/3/2022", "Ramón","Valentín de la Rubia Hernández", "Consultas de prueba","F05", true));
        this.medconRepository.save(new Consulta( 1 ,"30/3/2022", "Ramón","Marco César Maicas Ramos", "Consultas de prueba","P67", true));
        this.medconRepository.save(new Consulta( 0 ,"30/3/2022", "Ramón","Diego Martín de Andrés", "Consultas de prueba","D03", true));
        this.medconRepository.save(new Consulta( 3 ,"30/3/2022", "Ramón","Mateo Burgos García", "Consultas de prueba","U98", true));
        this.medconRepository.save(new Consulta( 4 ,"30/3/2022", "Ramón","Benito Artaloytia Encinas", "Consultas de prueba","K36", true));
        this.medconRepository.save(new Consulta( 5 ,"30/3/2022", "Ramón","Pablo Sánchez Olivares", "Consultas de prueba","G06", true));
        this.medconRepository.save(new Consulta( 6 ,"30/3/2022", "Ramón","Luis Mendo Tomas", "Consultas de prueba","L89", true));
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
    ResponseEntity<Consulta> updatedescartado(@PathVariable String id) {
        return medconRepository.findById(id).map(consulta ->{
            consulta.setDescartado(true);
            consulta.setTicketId(null);
            return ResponseEntity.ok().body(consulta);
        }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/consultas/descartados/{id}")
    ResponseEntity<Consulta> updateregistrado(@PathVariable String id) {
        return medconRepository.findById(id).map(consulta ->{
            consulta.setDescartado(false);
            return ResponseEntity.ok().body(consulta);
        }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
    //@PostMapping("/consultas/{id}")Para implementar el texto de la consulta ??
}
