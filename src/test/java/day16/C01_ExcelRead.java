package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws Exception {

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

        //ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//İLK HUCREDEKİ DATAYI AL

        //O VERİYİ YAZDIR
        System.out.println(cell1);

        //1. SATIR 2.SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        //3. SATIR 1. SUTUN YAZDIR VE O VERİNİN FRANCE OLDUGUNU TEST ET
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France", cell31);

        //Exceldeki toplam kullanılan satır sayısını bulun
        int toplamSatirSayisi = sheet1.getLastRowNum() + 1;//son satır numarası.index 0 dan baslıyor. sayma sayıları 1 den. +1 ekle
        System.out.println(toplamSatirSayisi);//11

        //Kullanılan toplam satır sayısını bulunuz
        int kullanılanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanılanToplamSatirSayisi);//1 DEN BASLIYOR

        //COUNTRY, CAPİTALS key ve valueları map a alıp print et
        //{{USA, D.C},{FRANCE,PARİS},...}

        //Variable olusturalım. Bu variable exceleki country, capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();

      for (int satirSayisi=1;satirSayisi<kullanılanToplamSatirSayisi;satirSayisi++){
          String country = sheet1.getRow(satirSayisi).getCell(0).toString();
          String capitals = sheet1.getRow(satirSayisi).getCell(1).toString();
          ulkeBaskentleri.put(country,capitals);
      }
        System.out.println(ulkeBaskentleri);

    }
}
