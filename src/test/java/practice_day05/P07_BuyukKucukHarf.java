package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P07_BuyukKucukHarf extends TestBase {
    @Test
    public void test03() {

        //google sayfasına gideklim
        driver.get("https://www.google.com.tr/");

        //Büyük kücük harf olacak sekilde HeLlO yazdıralım
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);


    }
}
