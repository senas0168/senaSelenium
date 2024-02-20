package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // -"https://www.hepsiburada.com/" adresine gidelim
        driver.get("https://www.hepsiburada.com/");

        // -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Basligi : " + actualTitle);
        System.out.println("Sayfa Url'i : " + actualUrl);

        // -title ve url'nin "Büyük" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Büyük") && actualUrl.contains("Büyük"));

        // -Ardindan "bershka.com" adresine gidelim
        driver.get("https://www.bershka.com/tr/");

        // -bu adresin basligini alalim ve "Giyim" kelimesini icerip icermedigini kontrol edelim
       String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Giyim"));

        // -Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        // -sayfayi yenileyelim
        driver.navigate().refresh();

        // -Daha sonra bershka sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
      driver.quit();//Birden fazla sayfada çalısılmıs ise quit() methodu kullanılır

    }
}
