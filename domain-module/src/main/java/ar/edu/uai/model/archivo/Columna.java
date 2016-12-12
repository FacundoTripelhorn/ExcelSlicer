package ar.edu.uai.model.archivo;

import javax.persistence.*;

/**
 * Created by Facu on 30/11/2016.
 */

public class Columna {
    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Columna(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
