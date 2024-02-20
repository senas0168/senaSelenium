package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {
    @Test
    public void keyboardActionsTest() {
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //'iPhone X fiyatlari' yazdir (SHIFT TUSUNA BASILARAK)
       WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
      // aramaKutusu.sendKeys("iPhone X fiyatlari"+ Keys.ENTER);

        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde shift tusuna bas
                .sendKeys("IPHONE X FİYATLARI")//shifte basılıyken yazı yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift de artık basma
                .sendKeys("   cok pahali!"+Keys.ENTER)//normal halde yaz ve enter tusuna bas
                .build()//birden fazla actions methodu kullanıldıgında build() onerilir
                .perform();
        //" cok pahali!' Yazdir (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

    }

}
