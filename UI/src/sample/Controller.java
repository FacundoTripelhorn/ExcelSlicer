import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.Celda;
import ar.edu.uai.model.archivo.Columna;
import ar.edu.uai.model.archivo.Fila;
import ar.edu.uai.paradigms.dao.ArchivoDAO;
import ar.edu.uai.paradigms.dao.GeneradorArchivo;
import ar.edu.uai.paradigms.service.impl.ArchivoServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void handleButtonClick() throws IOException {
        tablaTableView.getColumns().clear();
       Archivo archivo = generadorArchivo.cargarArchivo(pathTextField.getText());
        ObservableList<Celda> data = FXCollections.observableArrayList();
        for (Columna columna:archivo.getListaDeColumnas()) {
            TableColumn tableColumn=new TableColumn(columna.getNombre());
            tableColumn.setCellValueFactory(new PropertyValueFactory<Celda, String>(columna.getNombre()));
            tablaTableView.getColumns().add(tableColumn);
        }
        for(Fila fila:archivo.getListaDeFilas()){
            for (Celda celda:fila.getListaDeCeldas()){
              tablaTableView.getItems().add(celda.getValor());
            }
        }

    }


}