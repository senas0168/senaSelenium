package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {


    @Test
    public void rightClick() {
        //• https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 1. ACTİONS OBJESİ OLUSTUR
        Actions actions = new Actions(driver);

        //2. ELEMENTİ LOCATE EDELİM
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //Kutuya sag tıklayın
        //TUM ACTİONS LAR action OBJESİYLE BASLAR perform() İLE BİTER
        actions.contextClick(kutu).perform();

        //Alert'te cikan yazinin "You selected a context menu" oldugunu
        //Object olusturmak wait gerektiren durumlarda makul
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        // • Tamam diyerek alert'i kapatin
        driver.switchTo().alert().accept();

        /*
        1.Actions nedir? 2.Actions Class nedir?
        Actions selenium dan gelen bir kutuphanedir.Mouse ve keyboard
        işlemlerini gerçekleştirmek icin kullandıgımız hazır bır
        selenium kutuphanesidir. Ornegin, sag tıklamak(contextClick),
         cıft tıklamak(doubleClick), elementin uzerine gitmek(moveToElement)
         gercekleştirebilriz. Aynı zamanda shift, control, delete,
         enter gibi keyboard tuslarına da actions yardımıyla basabilriz.Bu tur islemlerde sendKeys methodu kullanılır.

        3.Ne tur methodlar kullandın
        Genelde actions methodları onemlidir. Ve tekrar tekrar kullanmam gerektiginden, Actions metotlarını
        içeren.Reusable methodları olusturdum. Ve gerektiginde bu reusable metodları kullanıyorum.
        Ornegin rightClick methodum bir elemente saga tıklamak icin test classımda cagırabilirim.

        4. Hangi methodları kullandın ve ne işe yarar?
        Ornegin, sag tıklamak(contextClick),
         cıft tıklamak(doubleClick), elementin uzerine gitmek(moveToElement)
         gercekleştirebilriz. Aynı zamanda shift, control, delete,
         enter gibi keyboard tuslarına da actions yardımıyla basabilriz.Bu tur islemlerde sendKeys methodu kullanılır.
         */

    }
}
