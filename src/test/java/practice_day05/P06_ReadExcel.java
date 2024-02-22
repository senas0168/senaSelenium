package practice_day05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P06_ReadExcel extends TestBase {
    /*
            <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
             <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
           1-  Öncelikli olarak dependency leri pom.xml'e yukluyoruz
           2- Dosya yolumuzu String bir degişkene atıyoruz
           3- ve bu dosyayı sistemde akısa alıyoruz
     */
    @Test
    public void name() throws IOException {
        //Bilgisayaranazdaki data isimli excel dosyasandon kullanaca bilgilerini alip
        String dosyaYolu = "C:\\Users\\SENA\\Desktop\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println("email = " + email);
        String password = workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println("password = " + password);

        // https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Excel dosyasindon aldıgımız kullonaca bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAdress = driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        emailAdress.sendKeys(email,Keys.TAB,password, Keys.ENTER);

        //Login oldugumuzu dogrulayalim
        WebElement login = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        assert  login.getText().equals("Erol Evren");
    }
}
