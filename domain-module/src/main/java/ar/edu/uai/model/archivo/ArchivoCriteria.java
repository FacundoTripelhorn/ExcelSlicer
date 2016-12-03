package ar.edu.uai.model.archivo;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoCriteria {

    private String nombre;
    private String path;

    public ArchivoCriteria(String nombre, String path) {
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ArchivoCriteria{" +
                "nombre='" + nombre + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
