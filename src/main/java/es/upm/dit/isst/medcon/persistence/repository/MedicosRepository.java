package es.upm.dit.isst.medcon.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.medcon.persistence.model.Medico;

public interface MedicosRepository extends CrudRepository<Medico, String>{
    List<Medico> findByUsuario(String usuario);
    List<Medico> findByNombre(String nombre);
}