package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.archivo.Archivo;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by GastónAlejandro on 10/12/2016.
 */
public class GeneradorArchivo {

    public void crearArchivo(Archivo archivo)
    {
        HSSFWorkbook miexcel =new HSSFWorkbook();
        File file =new File("C:\\Users\\Facu\\Desktop\\Java\\" + archivo.getNombre() + ".xls");
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


}
