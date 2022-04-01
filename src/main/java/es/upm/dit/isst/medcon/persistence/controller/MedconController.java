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
import es.upm.dit.isst.medcon.persistence.repository.PacientesRepository;
import es.upm.dit.isst.medcon.persistence.model.Consulta;
import es.upm.dit.isst.medcon.persistence.model.Medico;
import es.upm.dit.isst.medcon.persistence.model.Paciente;

@RestController
public class MedconController {
    private final MedconRepository medconRepository;
    private final PacientesRepository pacientesRepository;
    public static final Logger log = LoggerFactory.getLogger(MedconController.class);
    public MedconController(MedconRepository t, PacientesRepository p){
        this.pacientesRepository = p;
        this.pacientesRepository.save(new Paciente( 234567890, "45367876F", "María Asunción Santamaría Galdón", new Integer[] {7}));
        this.pacientesRepository.save(new Paciente( 987656435, "76262816D", "Jesús Frayle Ardanuy", new Integer[] {8}));
        this.pacientesRepository.save(new Paciente( 234654278, "72698765D", "Víctor Abraham Villagrá González", new Integer[] {9}));
        this.pacientesRepository.save(new Paciente( 287652288, "98224684F", "Gabriel Huecas Toribio", new Integer[] {10}));
        this.pacientesRepository.save(new Paciente( 876546892, "54378086E", "María de la Nava Maroto García", new Integer[] {11}));
        this.pacientesRepository.save(new Paciente( 987652728, "93214897H", "Juan Carlos Yelmo García", new Integer[] {12}));
        this.pacientesRepository.save(new Paciente( 896756288, "86456774F", "Valentín de la Rubia Hernández", new Integer[] {2}));
        this.pacientesRepository.save(new Paciente( 825522890, "45435698D", "Marco César Maicas Ramos", new Integer[] {1}));
        this.pacientesRepository.save(new Paciente( 985672890, "78653477H", "Diego Martín de Andrés", new Integer[] {0}));
        this.pacientesRepository.save(new Paciente( 989272890, "70454325F", "Mateo Burgos García", new Integer[] {3}));
        this.pacientesRepository.save(new Paciente( 637283790, "89573369H", "Benito Artaloytia Encinas", new Integer[] {4}));
        this.pacientesRepository.save(new Paciente( 293872290, "90643568D", "Pablo Sánchez Olivares", new Integer[] {5}));
        this.pacientesRepository.save(new Paciente( 234333210, "69292286G", "Luis Mendo Tomas", new Integer[] {6}));

        this.medconRepository = t;
        this.medconRepository.save(new Consulta( "7" ,"30/3/2022", "Ramón","María Asunción Santamaría Galdón", "Consultas de prueba","A01", false));
        this.medconRepository.save(new Consulta( "8" ,"30/3/2022", "Ramón","Jesús Frayle Ardanuy", "Consultas de prueba","D03", false));
        this.medconRepository.save(new Consulta( "9" ,"30/3/2022", "Ramón","Víctor Abraham Villagrá González", "Consultas de prueba","H69", false));
        this.medconRepository.save(new Consulta( "10" ,"30/3/2022", "Ramón","Gabriel Huecas Toribio", "Consultas de prueba","X43", false));
        this.medconRepository.save(new Consulta( "11" ,"30/3/2022", "Ramón","María de la Nava Maroto García", "Consultas de prueba","B02", false));
        this.medconRepository.save(new Consulta( "12" ,"30/3/2022", "Ramón","Juan Carlos Yelmo García", "Consultas de prueba","G54", false));
        this.medconRepository.save(new Consulta( "2" ,"30/3/2022", "Ramón","Valentín de la Rubia Hernández", "Consultas de prueba","F05", true));
        this.medconRepository.save(new Consulta( "1" ,"30/3/2022", "Ramón","Marco César Maicas Ramos", "Consultas de prueba","P67", true));
        this.medconRepository.save(new Consulta( "0" ,"30/3/2022", "Ramón","Diego Martín de Andrés", "Consultas de prueba","D03", true));
        this.medconRepository.save(new Consulta( "3" ,"30/3/2022", "Ramón","Mateo Burgos García", "Consultas de prueba","U98", true));
        this.medconRepository.save(new Consulta( "4" ,"30/3/2022", "Ramón","Benito Artaloytia Encinas", "Consultas de prueba","K36", true));
        this.medconRepository.save(new Consulta( "5" ,"30/3/2022", "Ramón","Pablo Sánchez Olivares", "Consultas de prueba","G06", true));
        this.medconRepository.save(new Consulta( "6" ,"30/3/2022", "Ramón","Luis Mendo Tomas", "Consultas de prueba","L89", true));
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
        Consulta c = medconRepository.findById(id).orElse(new Consulta());
        medconRepository.delete(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+","+c.getDescartado());
        c.setDescartado(true);
        c.setTicketId("");
        medconRepository.save(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+","+c.getDescartado());
        return new ResponseEntity<Consulta>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/consultas/descartados/{id}")
    ResponseEntity<Consulta> updateregistrado(@PathVariable String id) {
        return medconRepository.findById(id).map(consulta ->{
            consulta.setDescartado(false);
            return ResponseEntity.ok().body(consulta);
        }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
    //@PostMapping("/consultas/{id}")Para implementar el texto de la consulta ??

    @GetMapping("/paciente/login/dni/{dni}")
    Paciente readAllPacientesDni( @PathVariable String dni){
        return (Paciente) pacientesRepository.findByDni(dni);
    }

    @GetMapping("/paciente/login/cipa/{cipa}")
        Paciente readAllPacientesCipa( @PathVariable Integer cipa){
    return (Paciente) pacientesRepository.findByCipa(cipa);
    }
    //en el frontend tiene que coger para el paciente que le pasamos el id de su consulta (el priemro que este)
    //para hacer la llamada al put del ticketid
    @PutMapping("/paciente/ticketid/{id}") //pasamos como parametro el id de la consulta
    ResponseEntity<Consulta> ticketid(@PathVariable String id, @RequestBody Consulta newConsulta) {
        return medconRepository.findById(id).map(consulta ->{
            consulta.setTicketId(newConsulta.getTicketId());
            return ResponseEntity.ok().body(consulta);
        }).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }
}
