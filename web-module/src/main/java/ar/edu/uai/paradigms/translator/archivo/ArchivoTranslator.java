package ar.edu.uai.paradigms.translator.archivo;

import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.ArchivoCriteria;
import ar.edu.uai.paradigms.dto.archivo.ArchivoCriteriaDTO;
import ar.edu.uai.paradigms.dto.archivo.ArchivoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoTranslator {

    public Archivo translate(ArchivoDTO archivoDTO) {
        return new Archivo(archivoDTO.getId(), archivoDTO.getNombre(), archivoDTO.getPath());
    }

    public ArchivoDTO translateToDTO(Archivo archivo) {
        if (archivo != null) {
            return new ArchivoDTO(archivo.getId(), archivo.getNombre(), archivo.getPath());
        }
        return null;
    }

    public List<ArchivoDTO> translateToDTO(List<Archivo> archivos) {
        List<ArchivoDTO> archivoResponse = new ArrayList<ArchivoDTO>();
        for(Archivo a : archivos) {
            ArchivoDTO archivoDTO = this.translateToDTO(a);
            if(archivoDTO != null) {
                archivoResponse.add(archivoDTO);
            }
        }
        return archivoResponse;
    }

    public ArchivoCriteria translateCriteria(ArchivoCriteriaDTO archivoCriteriaDTO) {
        return new ArchivoCriteria(archivoCriteriaDTO.getNombre(), archivoCriteriaDTO.getPath());
    }
}
