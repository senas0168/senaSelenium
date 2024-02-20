package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 git
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();

        //Hello World! yazısının sitede oldugunu test et

        //1. Fluent Wait icin bir obje olustur EXPLİCİT WAİTTEN FARKI BU KISIM
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//MAX BEKLEME SURESİ
                .pollingEvery(Duration.ofSeconds(3))//DENEME ARALIKLARI
                .withMessage("IGNORE EXCEPTİON")//MESAJ YAZDIRABİLİRİM. ZORUNLU DEGİL
                .ignoring(NoSuchMethodException.class);//EXCEPTİON I HANDLE ET. ZORUNLU DEGİL

        //2. wait objesi kullanarak bekleme problemını coz
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }
}
