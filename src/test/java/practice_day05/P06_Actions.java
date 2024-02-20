package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P06_Actions extends TestBase {
    /*
        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        -Kutucuk igindeki rengi önce karmaza sonra sara yapanaz
        -Sari oldugunu test edelin
     */

    @Test
    public void name() {
//   -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

//        -Kutucuk igindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-175,0).perform();//Genellikle slider'lar icin bu method kullanılır
        actions.dragAndDropBy(maviTus,-80,0).perform();
        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();



//        -Sari oldugunu test edelim
        WebElement sari = driver.findElement(By.xpath("//div[@style='background-color: rgb(255, 255, 0);']"));
       Assert.assertTrue(sari.isDisplayed());
       // assert sari.isDisplayed();

    }
}
