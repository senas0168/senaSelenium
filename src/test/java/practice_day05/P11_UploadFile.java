package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class P11_UploadFile extends TestBase {
    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayaranazdan herhangi bir dosyayi upload ediniz
       // "C:\Users\SENA\Desktop\some-file.txt" //DOSYANIN GERCEK YOLUNU ALIP GÖREBİLMEK İCİN BURAYA KOYDUK

//        String farkliKisim = System.getProperty("user.home");//C:\Users\SENA
//        String ortakYol ="Desktop\\some-file.txt";
//        String dosyaYolu = farkliKisim+ortakYol;

        String dosyaYolu = "C:\\Users\\SENA\\Desktop\\some-file.txt";

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB, Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür oldugunu test edin
        waitFor(2);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();

    }

}
