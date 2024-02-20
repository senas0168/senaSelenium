package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P09_ExplicitWait extends TestBase {
    /*
                                            Explicit wait -
            Selenium'do Explicit Wait, Web Sürücüsüne belirli kosullari (Expected Condition) veya
     "ElementNotVisibleException" exception'ı atmadan ónce asılan maksinum süreyi beklemesini soylemek için kullanilir.
     Akilli bir bekleme türüdür ancak yolnizca belirli ögeler (elementler) için uygulanabilir.
     Dinamik olarak yüklenen web elementlert beklerken implicit wait'ten daha iyi secenekter sunar.

             Explicit wait kullandagimizda, "ExpectedConditions" tanımlamaliyiz veya Fluent Wait kullanarak durumu ne
     sıklıkla kontrol etmek istedigimizi yapilandirmaliyiz.

 Syntax:
       WebDriverwait wait = new WebDriverwait(driver, Duration.ofSeconds(30));
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));

     */

    //https://automationfc.github.io/dynamic-loading/ soyfasina gidelim
    //Start button'nuna basalim
    //Hello World! yazisinin cıktıgını dogrulayalim


    @Test
    public void visibilityTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasina gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalim
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! yazisinin cıktıgını dogrulayalim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));
        //Start butonuna bastıktan sonra Hello World! yazisi gorunene kadar bekledik

        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();

 }

    @Test
    public void invisibilityTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasina gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalim
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! yazisinin cıktıgını dogrulayalim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... ']")));
        //Start butonuna bastıktan sonra Loading webelewnti kaybolana kadar bekledik

        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();


    }
}
