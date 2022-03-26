package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

public interface SalaConsultaDAO{

    public void create (SalaConsulta salaconsulta);

    public void read (Long id);

    public void update (SalaConsulta salaconsulta);

    public void delete (SalaConsulta salaconsulta);

    public Collection<SalaConsulta> readAll();
}