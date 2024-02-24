package day02_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementsVeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");

        //Search bölumunu locate edelim
      // WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));

        //Search bölümünde iphone aratalım
        aramaKutusu.sendKeys("iphone", Keys.ENTER );

        /*
        Eğer bir web elementi(Web sayfasındaki herbir buton ya da text/yazı) locate(konumunu belirleme) etmek istersek
        once web sayfasını manuel olarak acıp sayfa uzerinde sag click yapıp incele'ye tıklaarız
        Karsımıza cıkan html kodlarından locater'lardan (konum belirleyiciler) eşsiz olanı seceriz.
        Genellikle id Attribute'u kullanılır. Sectigimiz attribute degerini findelement() metodu içine
        findelement(By.id("attribute degeri")) seklinde yazarız
         */
        //Amazon sayfasındaki <input> ve <a> taglarının sayısını yazdırınız

        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
        System.out.println("İnput Tag Sayısı = " + inputTags.size());

        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayısı = " + linklerList.size());

    }
}
