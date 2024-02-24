package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com.tr/ adresine gidin
        driver.get("https://www.amazon.com.tr/ ");

        // Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5 Sayfa basliginin “Elektronik” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKleime = "Elektronik";
        if (actualTitle.contains(arananKleime)) {
            System.out.println("Title Testi PASSED");
        } else System.out.println("Title Testi FAİLED");

        //6 Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gp/browse.html?node=16594144031&ref_=nav_cs_gc']")).click();
        //Thread.sleep(2000);


        //7 Birthday butonuna basin

        //<span class="a-size-medium a-color-base a-text-bold">Doğum Günü</span>
        //driver.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-bold']")).click();
        //     List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        //        System.out.println("Arama Sonuc Yazısı : " + aramaSonucYazisi.get(0).getText());
        //        List<WebElement> sonuclar = driver.findElements(By.xpath("(//*[text()='Doğum Günü'])[3]"));
        //        sonuclar.get(2).click();
        // driver.findElement(By.xpath("//*[text()='Doğum Günü']")).click();


        //        driver.findElement(By.cssSelector("div[class='a-section octopus-pc-category-card-v2-shield']")).click();
        //  driver.findElement(By.xpath("(//*[text()='Doğum Günü'])[3]")).click();
        driver.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-bold']")).click();

         //8 Best Seller bolumunden ilk urunu tiklayin
        List<WebElement> bestseller = driver.findElements(By.cssSelector("img[class='s-image']"));
        bestseller.get(0).click();

         //9- Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("li[class='a-spacing-mini gc-indexed gc-requires-js-inline-block gc-mini-amount gc-mini-amount1 gc-mini-amount-button']")).click();

        //10-Urun ucretinin 25$ oldugunu test edin

        WebElement urunUcreti = driver.findElement(By.cssSelector("span[id='gc-live-preview-amount']"));
        if (urunUcreti.getText().equals("TL100,00")){
            System.out.println("TEST PASSED");
        }  else  System.out.println("TEST FAİLED");


        //10-Sayfayi kapatin
        driver.close();
    }
}
