package day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Examples {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //İlk önce browser'i maximize yapalım sonra tüm sayfa icin max bekleme süresi olarak 15 sn belirtelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Sırasıyla amazon, facebook ve youtube sayfalarına gidelim.
        driver.get("https://www.amazon.com");
        driver.get("https://www.facebook.com");
        driver.get("https://www.youtube.com");

        //Amazon sayfasına tekrar dönelim
        driver.navigate().back();
        driver.navigate().back();

        //Amazon sayfasının Url'inin https://www.amazon.com/ adresine eşit oldugunu test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedlUrl = "https://www.amazon.com/";
        if (actualUrl.equals(expectedlUrl)) {
            System.out.println("Url TESTİ PASSED");
        } else System.out.println("Url TESTİ FAİLED");

        //Sayfanın konumunu ve pozisyonunu yazdırlım
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın Ölçüler'ı = " + driver.manage().window().getSize());

        //Sayfanın konumunu ve size'ını istedigimiz sekilde ayarlayalım
        driver.manage().window().setSize(new Dimension(600, 600));
        driver.manage().window().setPosition(new Point(50, 50));
        System.out.println("Sayfanın Yeni Ölçüler'ı = " + driver.manage().window().getSize());
        System.out.println("Sayfanın Yeni Konumu = " + driver.manage().window().getPosition());

        //ve istedigimiz şekilde oldugunu test edelim
        Dimension actualYeniSize = driver.manage().window().getSize();
        if (actualYeniSize.getWidth() == 600 && actualYeniSize.getHeight() == 600) {
            System.out.println("Size TESTİ PASSED");
        } else System.out.println("Size TESTİ FAİLED");

        Point actualYeniKonum = driver.manage().window().getPosition();
        if (actualYeniKonum.getX() == 50 && actualYeniKonum.getY() == 50) {
            System.out.println("Konum TESTİ PASSED");
        } else System.out.println("Konum TESTİ FAİLED");
        //ve sayfayı kapatalım
        driver.close();
    }
}
