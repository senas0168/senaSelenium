package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() {
        // 1 - https://www.amazon.com.tr sayfasana gidin
        driver.get("https://www.amazon.com.tr/");
       String sayfa1Handle= driver.getWindowHandle();

        // 2- nutella icin arame yapan
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // 3- yeni bir tab' da 1lk urunun resmine taklayan1z
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkUrun.click();

        // 4- yeni tab' da acilan urunun basligini yazdirin
       WebElement baslık = driver.findElement(By.xpath("//span[@id='productTitle']"));
       String baslikStr = baslık.getText();
        System.out.println("Baslik = " + baslikStr);

        // 5 - 1lk sayfaya gecip url'i yazdaran
        driver.switchTo().window(sayfa1Handle);

       String ilkSayfaUrl = driver.getCurrentUrl();
        System.out.println("Ilk Sayfa Url = " + ilkSayfaUrl);

    }
}
