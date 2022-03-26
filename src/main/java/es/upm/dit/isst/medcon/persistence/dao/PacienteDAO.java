package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

public interface PacienteDAO{

    public void create (Paciente paciente);

    public void read (String dni);

    public void update (Paciente paciente);

    public void delete (Paciente paciente);

    public Collection<Paciente> readAll();
}