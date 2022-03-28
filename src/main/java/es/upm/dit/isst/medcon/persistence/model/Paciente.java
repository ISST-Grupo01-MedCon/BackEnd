package es.upm.dit.isst.medcon.persistence.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Paciente")
public class Paciente implements Serializable{
    
    @Id
    private String dni;
    private String nombre;
    private Integer CIPA;
    private Integer consultaId;
    private Integer ticketId;

    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Integer getCIPA(){
        return CIPA;
    }
    public void setCIPA(Integer CIPA){
        this.CIPA = CIPA;
    }
    public Integer getConsultaId(){
        return consultaId;
    }
    public void setConsultaId(Integer consultaId){
        this.consultaId = consultaId;
    }
    public Integer getTicketId(){
        return ticketId;
    }
    public void setTicketId(Integer ticketId){
        this.ticketId = ticketId;
    }
}
