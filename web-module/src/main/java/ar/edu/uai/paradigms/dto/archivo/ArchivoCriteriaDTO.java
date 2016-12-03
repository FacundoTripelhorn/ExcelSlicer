package ar.edu.uai.paradigms.dto.archivo;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoCriteriaDTO {

    private String nombre;
    private String path;

    public ArchivoCriteriaDTO() {
    }

    public ArchivoCriteriaDTO(String nombre, String path) {
       this();
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ArchivoCriteriaDTO{" +
                "nombre='" + nombre + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
