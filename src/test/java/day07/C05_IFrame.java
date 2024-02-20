package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void iframeTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki "An iframe with a thin black border:" metninin "black border" oldugunu test edin
        String anaMetin = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrıca "Applications lists" yazısının sayfada oldugunu test edelim

        //Applications lists elementi iframe in içinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. Ilk iframe e gecis yapıyoruz

        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1= "Applications lists";
        Assert.assertEquals(icMetin,expectedText1);
        //Assert.assertTrue(expectedText1.contains(icMetin));//Alternatif olarak kullanılabilir



        //Son olarak footer daki "Povered By" yazısının varlıgını test edilip
        //Ana sayfadaki Povered By yazısını test etmek istiyorum ama driver hala iframe in icinde
        //Iframe ın dısına cıkmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//*[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
    //Handle Iframe Soruları
    //• How do you find the number of iframe on a page? Bir sayfadaki toplam iframe sayisini nasil buluruz?
    //• ***Iframe ler iframe tagi kullanilarak olusturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
    //***driver.findElements(By.tagName("iframe"));
    //• **driver.findElements(By.xpath(//iframe"));
    //Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
    //***2 farkli yol vardir.
    //* defaultContent yada parentFrame metotlarini kullarak gecis yapabiliriz.
    //• What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
    //** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent dire ana sayfaya atlatir, parentFrame ise bir üst seviyeye atlatir
    //•What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
    //1. Yanlis, locator. Cozum : Tekrar elementi locate etmek. Degisken element var ise ona gore dynamic bir xpath yazariz.
    //2. Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttirabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
    //3. Iframe. Cozum : switch to iframe
    //4. Alert. Cozum: switch to alert
    //5. New window (Yeni pencere) : switch to window

}
