package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Paciente")
public class Paciente implements Serializable {
    
    @Id
    private Integer cipa;
    private String dni;
    private String nombre;
    @Lob
    private Integer[] citas;

    public Paciente(Integer cipa, String dni, String nombre, Integer[] citas) {
        this.cipa = cipa;
        this.dni = dni;
        this.nombre = nombre;
        this.citas = citas;
    }
    public Paciente(){}

    public String getDni() {
        return dni;
    }
    public Integer getCipa() {
        return cipa;
    }
    public void setCipa(Integer cipa) {
        this.cipa = cipa;
    }
    public Integer[] getCitas() {
        return citas;
    }
    public void setCitas(Integer[] citas) {
        this.citas = citas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    
}




