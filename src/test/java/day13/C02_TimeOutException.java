package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException explicit wait kullandıgımda ve locator bulunamadıgında alırım
     */
    @Test
    public void timeOutExceptionTest() {
        driver.get("https://www.techproeducation.com");
        //Explicit wait icin olusturfugumuz methodlardan birini kullanabım
        //Parametre 1 : beklemek istedigim element, Parametre 2 : Max sure


//        waitForVisibility((By.xpath("//form[@class='search-formm']")),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));

    }
}
