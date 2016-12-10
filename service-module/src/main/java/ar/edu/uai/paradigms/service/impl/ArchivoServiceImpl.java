package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.ArchivoCriteria;
import ar.edu.uai.paradigms.dao.ArchivoDAO;
import ar.edu.uai.paradigms.dao.GeneradorArchivo;
import ar.edu.uai.paradigms.service.ArchivoService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoServiceImpl implements ArchivoService {

    private ArchivoDAO archivoDAO;

    public ArchivoServiceImpl(ArchivoDAO archivoDAO) {
        this.archivoDAO = archivoDAO;
    }

    @Transactional
    @Override
    public Archivo saveArchivo(Archivo archivo) {
        GeneradorArchivo generadorArchivo = new GeneradorArchivo();
        generadorArchivo.crearArchivo(archivo);
        return this.archivoDAO.create(archivo);
    }

    @Transactional
    @Override
    public Archivo retrieveArchivo(Integer identifier) {
        return this.archivoDAO.retrieve(identifier);
    }

    @Transactional
    @Override
    public void deleteArchivo(Integer identifier) {
this.archivoDAO.delete(identifier);
    }

    @Transactional
    @Override
    public List<Archivo> retrieveByCriteria(ArchivoCriteria criteria) {
       return this.archivoDAO.retrieveByCriteria(criteria);

    }

    @Transactional
    @Override
    public List<Archivo> retrieveAll() {
       return this.archivoDAO.retrieveAll();
    }
}
