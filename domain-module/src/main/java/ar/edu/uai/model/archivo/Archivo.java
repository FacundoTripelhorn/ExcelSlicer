package ar.edu.uai.model.archivo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Facu on 30/11/2016.
 */
@Entity
@Table(name= "ARCHIVO")
@Access(AccessType.FIELD)
public class Archivo {


    @Id
    @GeneratedValue
    @Column(name = "ARCHIVO_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PATH", nullable = false)
    private String path;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPath() {
        return path;
    }

    public Archivo() {
    }

    public Archivo(int id, String nombre, String path) {
       this.id=id;
        this.nombre = nombre;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Archivo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", path='" + path + '\'' +
                ", listaDeColumnas=" + listaDeColumnas +
                '}';
    }

    List<Columna> listaDeColumnas = new ArrayList<Columna>();

    public int GetFilas(){
        return 0;
    }
}
