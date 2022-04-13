package es.upm.dit.isst.medcon.persistence.controller;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.medcon.persistence.repository.MedconRepository;
import es.upm.dit.isst.medcon.persistence.repository.PacientesRepository;
import es.upm.dit.isst.medcon.persistence.model.Consulta;
//import es.upm.dit.isst.medcon.persistence.model.Medico;
import es.upm.dit.isst.medcon.persistence.model.Paciente;

@RestController
public class MedconController {
    private final MedconRepository medconRepository;
    private final PacientesRepository pacientesRepository;
    public static final Logger log = LoggerFactory.getLogger(MedconController.class);
    public MedconController(MedconRepository t, PacientesRepository p){
        this.pacientesRepository = p;
        p.save(new Paciente( 185672890, "78653477H", "Diego Martín de Andrés", new Integer[] {0}));
        p.save(new Paciente( 225522890, "45435698D", "Marco César Maicas Ramos", new Integer[] {1}));
        p.save(new Paciente( 396756288, "86456774F", "Valentín de la Rubia Hernández", new Integer[] {2}));
        p.save(new Paciente( 489272890, "70454325F", "Mateo Burgos García", new Integer[] {3}));
        p.save(new Paciente( 537283790, "89573369H", "Benito Artaloytia Encinas", new Integer[] {4}));
        p.save(new Paciente( 693872290, "90643568D", "Pablo Sánchez Olivares", new Integer[] {5}));
        p.save(new Paciente( 734333210, "69292286G", "Luis Mendo Tomas", new Integer[] {6}));
        p.save(new Paciente( 834567890, "45367876F", "María Asunción Santamaría Galdón", new Integer[] {7}));
        p.save(new Paciente( 917656435, "76262816D", "Jesús Frayle Ardanuy", new Integer[] {8}));
        p.save(new Paciente( 924654278, "72698765D", "Víctor Abraham Villagrá González", new Integer[] {9}));
        p.save(new Paciente( 937652288, "98224684F", "Gabriel Huecas Toribio", new Integer[] {10}));
        p.save(new Paciente( 946546892, "54378086E", "María de la Nava Maroto García", new Integer[] {11}));
        p.save(new Paciente( 987652728, "93214897H", "Juan Carlos Yelmo García", new Integer[] {12}));

        this.medconRepository = t;
        t.save(new Consulta( "7" ,"30/3/2022", "Ramón","María Asunción Santamaría Galdón", "Consultas de prueba","A01", false, true));
        t.save(new Consulta( "8" ,"30/3/2022", "Ramón","Jesús Frayle Ardanuy", "Consultas de prueba","D03", false, true));
        t.save(new Consulta( "9" ,"30/3/2022", "Ramón","Víctor Abraham Villagrá González", "Consultas de prueba","H69", false, true));
        t.save(new Consulta( "10" ,"30/3/2022", "Ramón","Gabriel Huecas Toribio", "Consultas de prueba","X43", false, true));
        t.save(new Consulta( "11" ,"30/3/2022", "Ramón","María de la Nava Maroto García", "Consultas de prueba","B02", false, true));
        t.save(new Consulta( "12" ,"30/3/2022", "Ramón","Juan Carlos Yelmo García", "Consultas de prueba","G54", false, true));
        t.save(new Consulta( "2" ,"30/3/2022", "Ramón","Valentín de la Rubia Hernández", "Consultas de prueba","F05", true, false));
        t.save(new Consulta( "1" ,"30/3/2022", "Ramón","Marco César Maicas Ramos", "Consultas de prueba","P67", true, false));
        t.save(new Consulta( "0" ,"30/3/2022", "Ramón","Diego Martín de Andrés", "Consultas de prueba","D03", true, false));
        t.save(new Consulta( "3" ,"30/3/2022", "Ramón","Mateo Burgos García", "Consultas de prueba","U98", true, false));
        t.save(new Consulta( "4" ,"30/3/2022", "Ramón","Benito Artaloytia Encinas", "Consultas de prueba","K36", true, false));
        t.save(new Consulta( "5" ,"30/3/2022", "Ramón","Pablo Sánchez Olivares", "Consultas de prueba","G06", true, false));
        t.save(new Consulta( "6" ,"30/3/2022", "Ramón","Luis Mendo Tomas", "Consultas de prueba","L89", true, false));
    }
    /**
     * API GET que devuelve la lista completa de consultas con sus atributos.
     * @return lista completa de consultas.
     */
    @GetMapping("/consultas")
    List<Consulta> readAll(){
        return (List<Consulta>) medconRepository.findAll();
    }

    /**
     * API GET que devuelve una consulta concreta por su ID
     * @param id el campo id de la consulta buscada.
     * @return la consulta con dicho id si existe.
     */
    @GetMapping("/consultas/{id}")
    ResponseEntity<Consulta> read(@PathVariable String id){
        return medconRepository.findById(id).map(consulta ->
            ResponseEntity.ok().body(consulta)
        ).orElse(new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND));
    }

    /**
     * API PUT que permite establecer un paciente como descartado o no descartado.
     * @param id el campo id de la consulta que se va a cambiar.
     * @return el código del resultado de la operación.
     */
    @PutMapping("/consultas/{id}")
    ResponseEntity<Consulta> updatedescartado(@PathVariable String id) {
        Consulta c = medconRepository.findById(id).orElse(new Consulta());
        if (c.getPaciente() == null || c.getPaciente() == "")
            return new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND);
        medconRepository.delete(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+","+c.getDescartado());
        c.setDescartado(c.getDescartado() ? false : true);
        medconRepository.save(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+","+c.getDescartado());
        return ResponseEntity.ok().body(c);
    }

    /**
     * API PUT que permite establecer un paciente como llamado o no llamado.
     * @param id el campo id de la consulta que se va a cambiar.
     * @return el código del resultado de la operación.
     */
    @PutMapping("/consultas/llamada/{id}")
    ResponseEntity<Consulta> updatellamado(@PathVariable String id) {
        Consulta c = medconRepository.findById(id).orElse(new Consulta());
        if (c.getPaciente() == null || c.getPaciente() == "")
            return new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND);
        medconRepository.delete(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+", llamado:"+c.getLlamado());
        c.setLlamado(c.getLlamado() ? false : true);
        medconRepository.save(c);
        System.out.println("Consulta:"+c.getId()+","+c.getPaciente()+", llamado: "+c.getLlamado());
        return ResponseEntity.ok().body(c);
    }

    /**
     * API GET que devuelve un paciente específico dado su DNI
     * @param dni el DNI con letra del paciente buscado
     * @return el paciente buscado si se encuentra.
     */
    @GetMapping("/paciente/login/dni/{dni}")
    Paciente readAllPacientesDni( @PathVariable String dni) {
        System.out.println("DNI: "+dni);
        return (Paciente) pacientesRepository.findByDni(dni);
    }

    /**
     * API GET que devuelve un paciente específico dado su CIPA
     * @param cipa el número CIPA del paciente buscado
     * @return el paciente buscado si se encuentra.
     */
    @GetMapping("/paciente/login/cipa/{cipa}")
    Paciente readAllPacientesCipa( @PathVariable Integer cipa){
        System.out.println("CIPA: "+cipa);
        return (Paciente) pacientesRepository.findByCipa(cipa);
    }

    //en el frontend tiene que coger para el paciente que le pasamos el id de su consulta (el primero que este)
    //para hacer la llamada al put del ticketid
    /**
     * API PUT que establece el ticketID del paciente con el ID pasado como parámetro a partir de la consulta enviada en el cuerpo de la petición.
     * @param id el ID de la consulta a la que se quiere asignar un ticketID.
     * @param newConsulta el objeto consulta que contiene dentro el ticketID deseado
     * @return el código del resultado de la operación.
     */
    @PutMapping("/paciente/ticketid/{id}") //pasamos como parametro el id de la consulta
    ResponseEntity<Consulta> ticketid(@PathVariable String id, @RequestBody Consulta newConsulta) {
        Consulta c = medconRepository.findById(id).orElse(new Consulta());
        if (c.getPaciente() == null || c.getPaciente() == "")
            return new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND);
        medconRepository.delete(c);
        c.setTicketId(newConsulta.getTicketId());
        medconRepository.save(c);
        return ResponseEntity.ok().body(c);
    }
    /**
     * API GET que devuelve la lista completa de pacientes con sus atributos.
     * @return lista completa de pacientes.
     */
    @GetMapping("/paciente")
    List<Paciente> readAllpacientes(){
        return (List<Paciente>) pacientesRepository.findAll();
    }
}
