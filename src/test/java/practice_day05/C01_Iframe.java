package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C01_Iframe extends TestBase {
    @Test
    public void test() {
        // https://html.com/tags/iframe sayfasina gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videovu görecek kadar asagiva ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        waitFor(3);

        // Videovu izlemek icin Play tusuna basiniz
        //Play' i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        // bunun uzerine html kodlarını inceleyince frame bir iframe in icinde oldugunu görfyk
        //Bunun icin once iframe ı llocate edip sonra switchTo() ile iframe'e gecmeliyiz

        WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        // Videovu calistirdiginizi test ediniz
        WebElement youTubeYazısı = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazısı.isDisplayed());

        // 'Powerful, but easy to misuse' yazisanin gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();//aldıgımız locaterdan eminsek ve ona ragmen hata alıyosak -> ilk once iframe den cıkmamız gerekir

        WebElement pBEtoMYazisi = driver.findElement(By.id("Powerful_but_easy_to_misuse"));
        Assert.assertTrue(pBEtoMYazisi.isDisplayed());
    }

}
