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
    private Boolean registrado;
    @Lob
    private byte[] textomedico;
    private Boolean descartado;
    private String ticketId;

    public Consulta(){}
    public Consulta(Integer id, String fecha, String medico, String paciente, String razonConsulta, Boolean registrado, byte[] textomedico, String ticketId, Boolean descartado){
        this.id = id;
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
        this.razonConsulta = razonConsulta;
        this.registrado = registrado;
        this.descartado = descartado;
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
    public Boolean getRegistrado(){
        return this.registrado;
    }
    public void setRegistrado(Boolean registrado){
        this.registrado = registrado;
    }

    public byte[] getTextomedico() {
        return this.textomedico;
    }

    public void setTextomedico(byte[] textomedico) {
        this.textomedico = textomedico;
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
