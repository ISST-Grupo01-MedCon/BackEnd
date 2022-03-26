package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

public interface ConsultaDAO{

    public void create (Consulta consulta);

    public void read (Long id);

    public void update (Consulta consulta);

    public void delete (Consulta consulta);

    public Collection<Consulta> readAll();
}