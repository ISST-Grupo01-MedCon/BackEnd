package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

public interface MedicoDAO{

    public void create (Medico medico);

    public void read (Long numeroColegiado);

    public void update (Medico medico);

    public void delete (Medico medico);

    public Collection<Medico> readAll();
}