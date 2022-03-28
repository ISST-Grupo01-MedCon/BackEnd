package es.upm.dit.isst.medcon.persistence.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SalaEspera")
public class SalaEspera implements Serializable{
    
    @Id
    private Integer id;
    private String nombre;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
