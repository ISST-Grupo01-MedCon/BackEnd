package es.upm.dit.isst.medcon.persistence.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Ticket")
public class Ticket implements Serializable{
    
    @Id
    private Integer id;
    private Integer numeroDeEspera;
    private String turnoDeEspera;
    private Integer salaEsperaId;
    private String fechaConsulta;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getNumeroDeEspera(){
        return numeroDeEspera;
    }
    public void setNumeroDeEspera(Integer numeroDeEspera){
        this.numeroDeEspera = numeroDeEspera;
    }
    public String getTurnoDeEspera(){
        return turnoDeEspera;
    }
    public void setTurnoDeEspera(String turnoDeEspera){
        this.turnoDeEspera = turnoDeEspera;
    }
    public Integer getSalaEsperaId(){
        return salaEsperaId;
    }
    public void setSalaEsperaId(Integer salaEsperaId){
        this.salaEsperaId = salaEsperaId;
    }
    public String getFechaConsulta(){
        return fechaConsulta;
    }
    public void setFechaConsulta(String fechaConsulta){
        this.fechaConsulta = fechaConsulta;
    }
}

