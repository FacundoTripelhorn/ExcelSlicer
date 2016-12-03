package ar.edu.uai.paradigms.controller.archivo;

import ar.edu.uai.paradigms.dto.archivo.ArchivoCriteriaDTO;
import ar.edu.uai.paradigms.dto.archivo.ArchivoDTO;
import ar.edu.uai.paradigms.service.ArchivoService;
import ar.edu.uai.paradigms.translator.archivo.ArchivoTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Facu on 3/12/2016.
 */

@Controller
@RequestMapping("/archivos")
public class ArchivoController {

    public ArchivoController(ArchivoService archivoService, ArchivoTranslator archivoTranslator) {
        this.archivoService = archivoService;
        this.archivoTranslator = archivoTranslator;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchivoController.class);
    private ArchivoService archivoService;
    private ArchivoTranslator archivoTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<ArchivoDTO> createPerson(@RequestBody ArchivoDTO archivoDTO) {
        LOGGER.debug("Received DTO: " + archivoDTO);
        return new ResponseEntity<ArchivoDTO>(this.archivoTranslator.translateToDTO(this.archivoService
                .saveArchivo(this.archivoTranslator.translate(archivoDTO))), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<ArchivoDTO>> retrieveByCriteria(ArchivoCriteriaDTO archivoCriteriaDTO) {
        LOGGER.debug("Received QUERY: " + archivoCriteriaDTO);
        return new ResponseEntity<List<ArchivoDTO>>(this.archivoTranslator.translateToDTO(this.archivoService
                .retrieveByCriteria(this.archivoTranslator.translateCriteria(archivoCriteriaDTO))), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<ArchivoDTO> getPerson(@PathVariable Integer identifier) throws InterruptedException {
        ArchivoDTO archivoDTO = this.archivoTranslator.translateToDTO(this.archivoService.retrieveArchivo(identifier));
        if (archivoDTO != null) {
            return new ResponseEntity<ArchivoDTO>(archivoDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ArchivoDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> deletePerson(@PathVariable Integer identifier) {
        this.archivoService.deleteArchivo(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
