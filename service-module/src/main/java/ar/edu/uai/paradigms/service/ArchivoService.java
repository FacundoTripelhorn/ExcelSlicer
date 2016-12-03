package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.ArchivoCriteria;

import java.util.List;

/**
 * Created by Facu on 3/12/2016.
 */
public interface ArchivoService {

    Archivo saveArchivo(Archivo archivo);

    Archivo retrieveArchivo(Integer identifier);

    void deleteArchivo(Integer identifier);

    List<Archivo> retrieveByCriteria(ArchivoCriteria criteria);

    List<Archivo> retrieveAll();
}
