import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.paradigms.dao.ArchivoDAO;
import ar.edu.uai.paradigms.dao.GeneradorArchivo;
import ar.edu.uai.paradigms.service.impl.ArchivoServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

public class Controller {


    GeneradorArchivo generadorArchivo = new GeneradorArchivo();
    ArchivoDAO archivoDAO = new ArchivoDAO();
    ArchivoServiceImpl archivoService = new ArchivoServiceImpl(archivoDAO);

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField pathTextField;

    @FXML
    private TableView tablaTableView;

    @FXML
    public void handleButtonClick(){
       generadorArchivo.crearArchivo(new Archivo(3, nombreTextField.getText(), pathTextField.getText()));
    }


}