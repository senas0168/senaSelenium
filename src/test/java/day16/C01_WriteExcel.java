package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //WORKBOOK > WORKSHEET > ROW > CELL > YAZ > KAYDET

        //WORKBOOK > WORKSHEET/SHEET > ROW > CELL
        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        // DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC/ SAYFA 1
        // Sheet sheet1 = workbook.getSheetAt(0);//index 0 dan baslar. ilk sayfayı ac
        Sheet sheet1 = workbook.getSheet("Sayfa1");//Sheet1 isimli sayfayı ac

        //ILK SATIRA GIT /Row
        Row row1 = sheet1.getRow(0);//İLK SATIRA GİT

        //İLK SATIR 3. SUTUNU CREATE ET
        Cell cell3 = row1.createCell(2);//!!!!

        //NUFUS YAZ
        cell3.setCellValue("NUFUS");//!!!!

        //2. satir 3. sutuna 4500
        sheet1.getRow(1).createCell(2).setCellValue("4500");

        //3. satir 3. sutuna 3500
        sheet1.getRow(2).createCell(2).setCellValue("3500");

        //KAYDET: KAYIT ISLEMI FİLE OUTPUT STREAM ILE YAPILIR
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}
