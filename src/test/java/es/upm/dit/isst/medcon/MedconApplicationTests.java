package es.upm.dit.isst.medcon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import antlr.collections.List;
import es.upm.dit.isst.medcon.persistence.model.Consulta;
import es.upm.dit.isst.medcon.persistence.model.Medico;
import es.upm.dit.isst.medcon.persistence.model.Paciente;
import es.upm.dit.isst.medcon.persistence.repository.MedconRepository;
import es.upm.dit.isst.medcon.persistence.repository.MedicosRepository;
import es.upm.dit.isst.medcon.persistence.repository.PacientesRepository;

@SpringBootTest
class MedconApplicationTests {

	@Autowired
    private MedconRepository repo;
	private PacientesRepository repo2;
	private MedicosRepository repo3;

	@Test
	final void testConsulta() {
		Consulta con = new Consulta();
		con.setId("7");
		con.setFecha("30/3/2022");
		con.setMedico("111222333");
		con.setPaciente("María Asunción Santamaría Galdón");
		con.setRazonConsulta("Consultas de prueba");
		con.setTicketId("A01");
		con.setDescartado(false);
		con.setLlamado(false);

		repo.save(con);


		Optional<Consulta> con2 = repo.findById("7");
		assertEquals(con2.get().getTicketId(), con.getTicketId());
		assertEquals(con2.get().getPaciente(), "María Asunción Santamaría Galdón");

		con.setLlamado(true);
        repo.save(con);
        con2 = repo.findById("7");
        assertNotEquals(con2.get().getRazonConsulta(), "Fractura de Brazo");
               
        repo.delete(con);
        con2 = repo.findById("7");
        assertFalse(con2.isPresent());
	}
	@Test
	final void testPaciente() {
		Paciente pac = new Paciente();
		pac.setCipa(185672890);
		pac.setDni("78653477H");
		pac.setNombre("Diego Martín de Andrés");
		pac.setCitas(new Integer[] {0});

		repo2.save(pac);

		Optional<Paciente> pac2 = repo2.findById("185672890");

		assertEquals(pac2.get().getCipa(), pac.getCipa());
		assertEquals(pac2.get().getDni(), "78653477H");
		assertEquals(pac2.get().getNombre(), "Diego Martín de Andrés");

		pac.setCitas(new Integer[] {0, 1});
        repo2.save(pac);

		assertNotEquals(pac2.get().getCitas(), pac.getCitas());	
		repo2.delete(pac);
		pac2 = repo2.findById("185672890");
		assertFalse(pac2.isPresent());
	}
	@Test
	final void testMedico() {
		Medico med = new Medico();
		med.setUsuario("111222333");
		med.setContraseña("MeEncantaISST");
		med.setNombre("Ramón");
		med.setOrdenPacientes(new int[] {7, 8, 9, 10, 11, 12});

		repo3.save(med);

		Medico med1 = (Medico) repo3.findByUsuario("111222333");

		assertEquals(med1.getNombre(), med.getContraseña());
		assertEquals(med1.getContraseña(), "MeEncantaISST");

		med1.setContraseña("nuevaCon");
        repo3.save(med1);
        assertNotEquals(med1.getContraseña(), med.getContraseña());
	}



}
