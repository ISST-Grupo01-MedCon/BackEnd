package es.upm.dit.isst.medcon.persistence.dao;

import java.util.Collection;
import es.upm.dit.isst.medcon.persistence.model.Ticket;

public interface TicketDAO{

    public void create (Ticket ticket);

    public void read (Long id);

    public void update (Ticket ticket);

    public void delete (Ticket ticket);

    public Collection<Ticket> readAll();
}