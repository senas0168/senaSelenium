package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void windowHandleTest() {
        //• https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();

        //• Sayfadaki textin "Opening a new window" oldugunu dogrulayin.
        String actualText1 = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedText1 = "Opening a new window";
        Assert.assertEquals(actualText1, expectedText1);

        //• Sayfa basliginin(title) "The Internet" oldugunu dogrulayin.
        String actualWindow1Title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(actualWindow1Title, expectedWindow1Title);

        //• Click Here butonuna basin.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        waitFor(3);

        //IKINCI PENCERE ACILIR VE IKINCI PENCEREDE İŞLEM YAPMAK İSTEDİGİMDEN, O PENCEREYE SWİTCH YAPMALIYIZ

        switchToWindow(1);//2. windowa geciş yaptık, driver artık 2.windowda


        //• Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu dogrulayin.
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertEquals(expectedWindow2Title,actualWindow2Title);

    }
}
