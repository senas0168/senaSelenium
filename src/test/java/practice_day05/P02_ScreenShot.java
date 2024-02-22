package practice_day05;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_ScreenShot extends TestBase {
    String tarih;
    @Test
    public void name() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");
        String amazonSayfasi = driver.getWindowHandle();

        //Tum sayfaların resmini alalım
         tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
        /*
        FİLEUTİLS CLASS'I, FİLE NESNELERİ İLE BİRLİKTE KULLANABİLECEGİMİZ METHODLAR ICERİR.
        BU METHODLARI KULLNARAK DOSYALARDA OKUMA,YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ

         */
        //Yeni bir sekmede techproeducatın sayfasına gıdıp sayfanın resmını alalım
        waitFor(3);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //Tekrar amazon sayfasına donup iphone aratalım
        driver.switchTo().window(amazonSayfasi);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);


        //arama sonucunun resmını alalım
        WebElement sonuc = driver.findElement(By.xpath(" //*[@class='a-section a-spacing-small a-spacing-top-small']"));
        FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+tarih+".jpeg"));


        //sonuc elementını locate edıp webelemente assıgn edın
        //        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));


    }

}
