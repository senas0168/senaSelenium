package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void fullPageScreeshotTest() throws IOException {
        /*
        Selenium da tum ekran goruntusu nasıl alınır?
        -tum ekran goruntusu selenıum dan gelen getScreeenshotAs metotu ile alınır.
        -getScreeenshotAs metotu selenıum daki TakeScreenshot api indan gelir
         */
        //Techpro education a git ve Sayfanin goruntusunu al]
        driver.get("https://techproeducation.com/");

        //  1. Ekran goruntusunu getScreenShotAs metotu ilr alıp File olarak olusturalım
       File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

       //2. Almıs oldugum ekran goruntusunu belirledigim bir PATH e kaydet.dir-directory=dosya
        //NOTE: kayit ismini dinamik yapmak icin date objesi kullandım
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
       File hedef = new File(path);

       //3. Goruntum ile doysamı birleştirip kaydet
        FileUtils.copyFile(goruntu,hedef);

        //Alternatif olarak tum bu adımları tek seferde degişken kullanmmadan yapabilirim
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path


        //- "Tester" aramasi yap
        driver.findElement(By.xpath("(//a[@href='/program/full-stack-automation-tester'])[1]")).click();

        waitFor(3);
        String expected ="Tester";
        //Acilan sayfanin metnini test et ve ekran goruntusu al: "Search Results for: Full Stack Automation Tester"
        String text =  driver.findElement(By.xpath("//b[text()='Full Stack Automation Tester']")).getText();
        Assert.assertTrue(text.contains(expected));

        //Reusable metod yardimiyla ekran goruntusunu alalım
        takeScreenShotOfPage();


    }
}
