package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Consulta")
public class Consulta implements Serializable{
    
    @Id
    private String id;
    private String fecha;
    private String medico;
    private String paciente;
    private String razonConsulta;
    @Lob
    private Boolean descartado;
    private String ticketId;

    public Consulta(){}
    public Consulta(String id, String fecha, String medico, String paciente, String razonConsulta, String ticketId, Boolean descartado){
        this.id = id;
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
        this.razonConsulta = razonConsulta;
        this.descartado = descartado;
        this.ticketId = ticketId;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMedico() {
        return this.medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return this.paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getRazonConsulta() {
        return this.razonConsulta;
    }

    public void setRazonConsulta(String razonConsulta) {
        this.razonConsulta = razonConsulta;
    }
    public Boolean getDescartado(){
        return descartado;
    }
    public void setDescartado(Boolean descartado){
        this.descartado = descartado;
    }
    public String getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }


}
