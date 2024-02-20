package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {
        //• https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //ILK SAYFANIN ID SINI ALALIM
        String window1Handle = driver.getWindowHandle();

        //• Sayfadaki textin "Opening a new window" oldugunu dogrulayin.
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", window1Text);

        //• Sayfa basliginin(title) "The Internet" oldugunu dogrulayin.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet", window1Title);

        //• Click Here butonuna basin.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        // BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECİS YAPMAK İSTİYORUM
        //BUNUN İÇİN driver.getWindowHanles() ILE TUM PENCERELERİN ID LERİNİ ALALIM
        Set<String> allWindowHandles = driver.getWindowHandles();//{window1Handle,window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles) {
            //eger listedeki id window1 e esit degilse, otomarik olarak window2 ye esittir
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);//Buradaki eachHandle window2 handle ına esittir
                break;
            }


        }
        //BU NOKTADA DRİVER 2. PENCEREDE
        //• Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        // • Sayfadaki textin "New Window" oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());

        String window2Handle = driver.getWindowHandle();
        //• Bir önceki pencereye geri döndükten sonra sayfa basliginin "The Internet" oldugunu dogrulayin.

        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(3000);

        //2. window a tekrar gecelim
        driver.switchTo().window(window2Handle);

        //1. window a tekrar gecelim
        driver.switchTo().window(window1Handle);

    }
}
