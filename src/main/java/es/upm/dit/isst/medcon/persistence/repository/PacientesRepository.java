package es.upm.dit.isst.medcon.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.medcon.persistence.model.Paciente;

public interface PacientesRepository extends CrudRepository<Paciente, String>{
    List<Paciente> findByDni(String dni);
    List<Paciente> findByCipa(Integer cipa);
}
