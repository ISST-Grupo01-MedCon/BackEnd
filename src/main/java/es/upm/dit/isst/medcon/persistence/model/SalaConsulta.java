package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SalaConsulta")
public class SalaConsulta implements Serializable{
    
    @Id
    private Integer Id;
    private Integer numero;
    private Integer salaEsperaId;
    private Integer consultaId;
    

    public Integer getId(){
        return Id;
    }
    public void setId(Integer Id){
        this.Id = Id;
    }
    public Integer getNumero(){
        return numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    public Integer getSalaEsperaId(){
        return salaEsperaId;
    }
    public void setSalaEsperaId(Integer salaEsperaId){
        this.salaEsperaId = salaEsperaId;
    }
    public Integer getConsultaId(){
        return consultaId;
    }
    public void setConsultaId(Integer consultaId){
        this.consultaId = consultaId;
    }
}
