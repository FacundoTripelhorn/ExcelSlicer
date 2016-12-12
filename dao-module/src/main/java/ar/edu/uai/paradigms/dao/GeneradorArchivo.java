package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.Celda;
import ar.edu.uai.model.archivo.Columna;
import ar.edu.uai.model.archivo.Fila;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by GastónAlejandro on 10/12/2016.
 */
public class GeneradorArchivo {

    public void crearArchivo(Archivo archivo)
    {
        HSSFWorkbook miexcel =new HSSFWorkbook();
        File file =new File(archivo.getPath()+ "\\" + archivo.getNombre() + ".xls");
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        HSSFSheet hojaNumero1 = miexcel.createSheet("HojaNumero1");
        HSSFRow row = hojaNumero1.createRow(0);
        HSSFCell celda = row.createCell(0);
        HSSFFont mifuente =miexcel.createFont();
        HSSFCellStyle cs=miexcel.createCellStyle();
        mifuente.setColor(HSSFFont.COLOR_RED);
        mifuente.setItalic(true);
        mifuente.setFontHeight((short) 350);
                cs.setFont(mifuente);
        celda.setCellValue("Path elegido: " + archivo.getPath());
        celda.setCellStyle(cs);
        hojaNumero1.autoSizeColumn(0);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file.getPath());
            miexcel.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Archivo cargarArchivo(String excelFilePath) throws IOException {
        int id=0;
      Archivo archivo = new Archivo();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

    Workbook workbook = new HSSFWorkbook(inputStream);
    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();

    while (iterator.hasNext()){
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        Fila fila = new Fila(nextRow.getRowNum());

        while (cellIterator.hasNext()){
            Cell cell=cellIterator.next();
            Celda celda= new Celda(cell.getStringCellValue());
            fila.agregarCelda(celda);
        }
        if (fila.getId()==0){
            for (Celda celda: fila.getListaDeCeldas()){
                archivo.getListaDeColumnas().add(new Columna(id, celda.getValor()));
            }
        } else {
            archivo.agregarFila(fila);
        }
    }

    workbook.close();
    inputStream.close();
        return archivo;
    }
}
