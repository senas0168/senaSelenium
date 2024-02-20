package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class HWActions01 extends TestBase {
    @Test
    public void test00() {
        //https://demoga.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        WebElement kutu = driver.findElement(By.xpath("(//*[@class='card-up'])[6]"));
        //clickwithText("div.card-body>h5", "Alerts, Frame & Windows");
        Actions actions = new Actions(driver);
       // actions.moveToElement(kutu).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();

        //""Please select on item from left to start practice."" yazisinin gorunur oldugunu dogrula
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());

        //Sol'da açılan Menu den ""Blowser windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //New Tab butonunun görünür oldugunu dogrula
        WebElement newTabButon = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTabButon.isDisplayed());

        //New Tab butonuna click yap
        newTabButon.click();//kontrolum dısında yenı bır pencere acıldıgında ArrayListe windowhandles ları atıyorum

        //Açilan yeni Tab da ""This is a sample page"" yazisinan görünür oldugunu dogrula
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //Ilk Tab'a geri dön
        driver.switchTo().window(allWindow.get(0));

        ////New Tab butonunun görünür oldugunu dogrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
    }
}
