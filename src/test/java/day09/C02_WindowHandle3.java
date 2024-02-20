package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void newWindowHandleTest() {
        //1.TechPro education sayfasının title'ının "TechPro Education" metnini içerdigini test edin
        driver.get("https://techproeducation.com/");
        Assert.assertTrue(driver.getTitle().contains("TechPro Education"));
        String techProHandle = driver.getWindowHandle();

        //2. Yeni bir pencerede Amazon sayfasını acıp title'ının "Amazon" metnini içerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1. yeni pencere olusturur 2. Oraya geciş yapar
        driver.get("https://www.amazon.com.tr/");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede linkedin sayfasını acıp title'ının "LinkedIn" metnini içerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1. yeni pencere olusturur 2. Oraya geciş yapar
        driver.get("https://www.linkedin.com/");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);
        //DRİVER NEREDE? LİNKEDİNDE
        //TECHPRO SAYFASINA GİTMEK İÇİN TEKRAR driver.switchTo().window(techProHandle);
        driver.switchTo().window(techProHandle);
        waitFor(3);
        //DRİVER NEREDE? TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("TechPro Education"));
        waitFor(3);
    }
}
