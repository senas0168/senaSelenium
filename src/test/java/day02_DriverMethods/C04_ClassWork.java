package day02_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C04_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chromedriver.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Acılan browser'ı tam ekran yap
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com.tr/");

        //b. Search(ara) “city bike” //id attribute'u varsa ilk olarak o kullanılır
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Arama Sonuc Yazısı : " + aramaSonucYazisi.get(0).getText());

        //Arama sonuc sayısını console a yazdırınız
        String [] sonucSayisi = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc Sayisi : "+ sonucSayisi[0]);

        //Sonuc sayısını LAMBDA ile yazdırınız
        Arrays.stream(aramaSonucYazisi.get(0).getText().split(" ")).limit(3).skip(2).forEach(System.out::println);
        Thread.sleep(2000);

        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> ilkWE = driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();
    }
}
