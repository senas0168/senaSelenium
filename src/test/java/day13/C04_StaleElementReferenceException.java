package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void StaleElementReferenceExceptionTest1() {
        driver.get("https://www.techproeducation.com");
        //LMS login linkine tıkla ve o sayfanın url ının lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.xpath("//a[@href='https://lms.techproeducation.com/']"));
        waitFor(3);
        lmsLoginLink.click();
        waitFor(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("techproeducation"));

        //Tekrar ana sayfaya gel ve lms login sayfasına tekrar gel
        driver.navigate().back();
        waitFor(3);
        lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException:

   /*
   lmsLoginLink linkini sayfa yenilendikten (back()) sonra kullandıgım ıcın StaleElementReferenceException aldım
    */


    }

    @Test
    public void StaleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.xpath("//a[@href='https://lms.techproeducation.com/']"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        //SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKTEN SONRA KULLANMAK ISTEDIM
        lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException:

        // COZUM ESKİ (STALE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        //driver.findElement(By.xpath("//a[@href='https://lms.techproeducation.com/']")).click();

    }
}
