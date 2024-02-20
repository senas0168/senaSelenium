package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {
    @Test
    public void testActions() {
        //- http://szimek.github.io/signature_pad/ sayfasino gidiniz
        //- Çıkan ekrana istediginiz cizgi yada sekli ciziniz
        //  Çizimden sonra clear butonuna basalım
        //- Son olarak soyfoya temizleyiniz

        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();

        for (int i = 0; i <10 ; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        waitFor(5);
        driver.findElement(By.xpath("//button[text()='Clear']")).click();
    }
}
