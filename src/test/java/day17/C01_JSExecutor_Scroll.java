package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {
        //scrollIntoViewTest metotu olustur
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com/");
        waitFor(3);

        //Programs elementi gorunur olacak sekilde uzerine scroll et ve ekran goruntusunu al

        //1. Elementi bul
        WebElement programs = driver.findElement(By.xpath("//h1[text()='Programs']"));
        waitFor(3);

        //2. JS executor objesi olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //3. Yapmak istedigim islemı js.executeScript metotu ile yap
        //scrollIntoView(true); metotu belirli bir elemente scroll yapmak ıcın kullanılır
        // arguments[0] ILK PARAMETREDEKİ ELEMENT

        js.executeScript("arguments[0].scrollIntoView(true);", programs);
        waitFor(3);
        //sayfa goruntusunu al
        takeScreenShotOfPage();

        //Ayni sayfada mail elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.className("footerMail")));
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekcan geruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath(" //h2[.='Testimonials']")));
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada tekcar Enroll Free elementi gorunur glacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.className("footerMail")));
        waitFor(3);
        takeScreenShotOfPage();

        //EN USTE GİT
        scrollTopJS();
        waitFor(3);

        //EN ALTA GİT
        scrollEndJS();
        waitFor(3);
    }
}
