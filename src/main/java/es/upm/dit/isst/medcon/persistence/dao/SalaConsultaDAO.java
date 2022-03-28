package es.upm.dit.isst.medcon.persistence.dao;

import java.util.Collection;
import es.upm.dit.isst.medcon.persistence.model.SalaConsulta;

public interface SalaConsultaDAO{

    public void create (SalaConsulta salaconsulta);

    public void read (Long id);

    public void update (SalaConsulta salaconsulta);

    public void delete (SalaConsulta salaconsulta);

    public Collection<SalaConsulta> readAll();
}