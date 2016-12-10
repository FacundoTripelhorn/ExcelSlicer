package ar.edu.uai.paradigms.dto.archivo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoDTO {

    private Integer id;
    private String nombre;
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

    @JsonCreator
    public ArchivoDTO(@JsonProperty("Id") Integer id,@JsonProperty("Nombre") String nombre,@JsonProperty("Path") String path) {
        this.id = id;
        this.nombre = nombre;
        this.path = path;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [Id=" + id + ", Name=" + nombre + ", Path=" + path + "]";
    }
}
