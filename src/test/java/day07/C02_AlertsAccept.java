package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //  1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //uyarıdaki OK butonuna tıklayın
        Thread.sleep(5000);
        driver
                .switchTo()//degiştir
                .alert()//alerte degiştir
                .accept();//OK secenegine tıklanır
        Thread.sleep(5000);
        // ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);

    }
    /*
    Alertleri nasıl automate edersin? How to handle alerts in selenium?
     -Alertler javascript ile olusur. Inspect(incele) edilemezler.Oncelikle alerte switch etmemiz gerekir

     */
}
