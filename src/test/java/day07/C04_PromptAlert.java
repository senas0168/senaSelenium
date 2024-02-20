package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    @Test
    public void promptAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 3.butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Sena");
        Thread.sleep(5000);
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //ve result mesajında isminizin görüntülendiğini doğrulayın
        String actualResult = driver.findElement(By.id("result")).getText();//You entered: Sena
        String expectedResult = "Sena";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
