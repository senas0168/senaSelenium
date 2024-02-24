package day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com.tr");

        //Arama kutusunu locate ediniz
       /*
       <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Ara Amazon.com.tr"
       class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Ara Amazon.com.tr" spellcheck="false">
        */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //Arama kutusununun tagName'inin input oldugunu test ediniz
        String actualTagname = aramaKutusu.getTagName();
        String expectedTagname = "input";
        if (actualTagname.equals(expectedTagname)) {
            System.out.println("Tagname Testi PASSED : " + actualTagname);
        } else System.out.println("Tagname Testi FAİLED : " + actualTagname);

        // Thread.sleep(3000);

        //Arama kutusunun name attribut'unun degerinin field-keywords oldugunu test ediniz
        String actualAttributename = aramaKutusu.getAttribute("name");
        String expectedAttributename = "field-keywords";
        if (actualTagname.equals(expectedAttributename)) {
            System.out.println("Attribute TESTİ PASSED");
        } else System.out.println("Attribute TESTİ FAİLED");

        //Sayfayı kapatnız
        driver.close();

    }
}
