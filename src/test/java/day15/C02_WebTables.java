package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    //https://the-internet.herokuapp.com/tables
    //Task 1 : Tablel'i print edin
    //Task 2 : 3. Row' datalarina print edin
    //Task 3 : Son row daki datalarz print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot olusturalim: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData (2,3);=> 2nd row, 3rd column daki datayz print etsin
    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());
    @Test
    public void table1Print() {

        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        logger.info("TABLE 1 VERİLERİ");
        System.out.println(table1);
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));

        //  tumVeriler.stream().forEach(t-> System.out.println( t.getText()));//LAMBDA

        for (WebElement veri : tumVeriler) {
            System.out.println(veri.getText());
        }
    }

    @Test
    public void rom3Print() {
        //Task 2 : 3. Row' datalarina print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
//        for (WebElement ucuncuStrElement : row3Elements){
//            System.out.println(ucuncuStrElement.getText());
//        }
        row3Elements.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void sonSatirVerileri() {
        //Task 3 : Son row daki datalarz print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(t -> System.out.println(t.getText()));


//        for (WebElement veri:sonSatir) {
//            System.out.println(veri.getText());
//        }
    }

    @Test
    public void sutun5Test() {
        //Task 4 : 5. Column datalarini print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> column5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        column5.forEach(t -> System.out.println(t.getText()));

    }


    public void printData(int satir, int sutun) {
        //Task 5 : Iki parametreli bir Java metot olusturalim: printData
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr[" + satir + "]//td[" + sutun + "]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }

    @Test
    public void printDataTest() {
        printData(2,3);//fbach@yahoo.com

        printData(1,2); //John
    }
}
