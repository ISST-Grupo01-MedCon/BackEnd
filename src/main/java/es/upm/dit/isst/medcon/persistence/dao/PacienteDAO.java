package es.upm.dit.isst.medcon.persistence.dao;
import java.util.Collection;
import es.upm.dit.isst.medcon.persistence.model.Paciente;

public interface PacienteDAO{

    public void create (Paciente paciente);

    public void read (String dni);

    public void update (Paciente paciente);

    public void delete (Paciente paciente);

    public Collection<Paciente> readAll();
}