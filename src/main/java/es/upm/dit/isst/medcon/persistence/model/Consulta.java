package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Consulta")
public class Consulta implements Serializable{
    
    @Id
    private Integer id;
    private String fecha;
    private String especialidad;
    private Integer medicoId;
    private Integer salaConsultadId;
    private Integer salaEsperadId;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public Integer getMedicoId(){
        return medicoId;
    }
    public void setMedicoId(Integer medicoId){
        this.medicoId = medicoId;
    }
    public Integer getSalaConsultaId(){
        return salaConsultadId;
    }
    public void setSalaConsultaId(Integer salaConsultaId){
        this.salaConsultadId = salaConsultaId;
    }
    public Integer getSalaEsperaId(){
        return salaEsperadId;
    }
    public void setSalaEsperaId(Integer salaEsperaId){
        this.salaEsperadId = salaEsperaId;
    }
}
