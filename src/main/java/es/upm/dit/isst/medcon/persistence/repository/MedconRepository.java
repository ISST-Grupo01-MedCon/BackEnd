package es.upm.dit.isst.medcon.persistence.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import es.upm.dit.isst.medcon.persistence.model.Consulta;

public interface MedconRepository extends CrudRepository<Consulta, String>{
    List<Consulta> findByPaciente(String tutor);
}
