package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Medico")
public class Medico implements Serializable{
    
    @Id
    private Integer numColegiado;
    private String nombre;
    private String especialidad;
    private Integer salaConsultadId;
    private Integer salaEsperadId;

    public Integer getNumColegiado(){
        return numColegiado;
    }
    public void setNumColegiado(Integer numColegiado){
        this.numColegiado = numColegiado;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public Integer getSalaCondultaId(){
        return salaConsultadId;
    }
    public void setSalaConsultaId(Integer salaConsultadId){
        this.salaConsultadId = salaConsultadId;
    }
    public Integer getSalaEsperaId(){
        return salaEsperadId;
    }
    public void setSalaEsperaId(Integer salaEsperadId){
        this.salaEsperadId = salaEsperadId;
    }
}
