package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

public interface SalaEsperaDAO{

    public void create (SalaEspera salaEspera);

    public void read (Long id);

    public void update (SalaEspera salaEspera);

    public void delete (SalaEspera salaEspera);

    public Collection<SalaEspera> readAll();
}