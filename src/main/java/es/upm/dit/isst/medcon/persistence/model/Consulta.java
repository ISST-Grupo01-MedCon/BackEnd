package es.upm.dit.isst.medcon.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Consulta")
public class Consulta implements Serializable{
    
    @Id
    private Integer id;
    private String fecha;
    private String medico;
    private String paciente;
    private String razonConsulta;
    @Lob
    private byte[] textomedico;
    private String ticketId;

    public Consulta(){}
    public Consulta(Integer id, String fecha, String medico, String paciente, String razonConsulta, byte[] textomedico, String ticketId){
        this.id = id;
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
        this.razonConsulta = razonConsulta;
        this.textomedico = textomedico;
        this.ticketId = ticketId;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public byte[] getTextomedico() {
        return this.textomedico;
    }

    public void setTextomedico(byte[] textomedico) {
        this.textomedico = textomedico;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }


}
