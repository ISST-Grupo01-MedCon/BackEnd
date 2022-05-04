package es.upm.dit.isst.medcon.persistence.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Medico")
public class Medico implements Serializable{
    
    @Id
    private String usuario;
    private String contraseña;
    private String nombre;
    private String salaDeConsulta;
    private int[] ordenPacientes;

    public Medico(){}
    public Medico(String usuario, String contraseña, String nombre, String salaDeConsulta, int[] ordenPacientes) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.salaDeConsulta = salaDeConsulta;
        this.ordenPacientes = ordenPacientes;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalaDeConsulta(String salaDeConsulta) {
        this.salaDeConsulta = salaDeConsulta;
    }

    public String getSalaDeConsulta() {
        return salaDeConsulta;
    }

    public int[] getOrdenPacientes() {
        return ordenPacientes;
    }

    public void setOrdenPacientes(int[] ordenPacientes) {
        this.ordenPacientes = ordenPacientes;
    }

}

