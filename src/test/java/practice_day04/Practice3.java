package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice3 extends TestBase {


    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tiklayin
        WebElement iframe = driver.findElement(By.xpath(" //*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm ikinci emoji ögelerini tiklayin

        // List<WebElement> emojiler = driver.findElements(By.xpath("(//div[@id='nature']//text())"));
        // emojiler.stream().forEach(t-> t.click());//lambda ile tum webelementlere tıkladık

        //        for (WebElement w: emojiler) {
        //            w.click();
        //        }

        // parent iframe e geri donun
        driver.switchTo().defaultContent();
      //  driver.navigate().refresh();

        // formu doldurun, (Formu istediginiz metinterle daldurun)
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList("Sena","Ok","selenium","lambda","java","sql","gitgithub","asda","aflalş","sldfm","fkaş","şdfl","şdlsş"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }
        
        //apply button a basin
        driver.findElement(By.id("send")).click();
    }
}
