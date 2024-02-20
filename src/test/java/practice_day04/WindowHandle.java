package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.sql.Driver;

public class WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com.tr/");

        //Sayfa'nin window handle degerina String bir degiskene atoyin
       String amazonWindow = driver.getWindowHandle();

        //Sayfa title nin "Amazon" icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKelime = "Amazon";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //yeni bir tab otusturup, acilan tab da techproeducation.com adresine gidin
       driver.switchTo().newWindow(WindowType.TAB); //Yeni bir sekme acmıs olduk
        driver.get("https://techproeducation.com");

        // Sayfa title nin "TECHPROEDUCATION" icermedigini test edin
        String actualTechProTitle = driver.getTitle();
        String istenenKelime = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechProTitle.contains(istenenKelime));

        //Yeni bir window oLusturup, acilon sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com/");

        //Sayfa title nin "Walmart" icerdigini test edin
        String actualWalmartTitle = driver.getTitle();
        String beklenenKelime = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(beklenenKelime));

        //Ilk acilan sayfayo donun ve amazon sayfasino dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com.tr/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
