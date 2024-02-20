package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 git
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();
        // WebElement helloWorldElement = driver.findElement(By.xpath("//*[@id='finish']//h4"));
        // Assert.assertEquals("Hello World!",helloWorldElement.getText());
        //IMPLICIT WAİT İLE TEST CASE CALISMADI
        //COZUM EXPLİCİT WAİTDE
        //Hello World! yazısının sitede oldugunu test et

        //1.WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //2. wait objesini kullanrak bekleme problemini cözmeye calıs
       WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
       String helloWorldText =helloWorldElement.getText();
       Assert.assertEquals("Hello World!",helloWorldText);

    }
}
