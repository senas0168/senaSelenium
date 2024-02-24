package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_ClassWork {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //Amazon sayfasına gidelim. https://wwww.amazon.com"/
        driver.get("https://wwww.amazon.com");
        //sayfa baslıgını(title) yazdırın
        System.out.println("Sayfa Baslığı = " + driver.getTitle());
        //sayfa baslıgının "Amazon" icerdigini test
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Amazon")){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAİLED");
        //sayfa adresini(url) yazdırın
        System.out.println("Sayfa Url'i " + driver.getCurrentUrl());
        //sayfa url'nin "amazon" icerdigini test edin
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains("amazon")){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAİLED");
        //sayfa handle degerini yazdırın
        System.out.println("Window Handle Degeri = " + driver.getWindowHandle());
        //sayfa HTML kodlarında "Gateway" kelimesi gectigini test edin
        String sayfaKodlari = driver.getPageSource();
        if (sayfaKodlari.contains("Gateway")){
            System.out.println("Source Code Testi PASSED");
        }else  System.out.println("Source Code Testi FAİLED");
        //sayfayı kapatın
        driver.close();//Sayfayi kapatmak icin close() methodu kullanırız





    }

}
