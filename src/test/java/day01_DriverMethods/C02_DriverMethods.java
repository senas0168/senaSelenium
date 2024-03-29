package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();//Bos bir browser açtık
        driver.get("https://wwww.amazon.com");//ilk olarak gitmek istediğimiz sayfayı belirtiriz
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        System.out.println("Sayfa Url'i : = " + driver.getCurrentUrl());
       // System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());//Bize o window'a ait hash değerini verir. Biz bu hash degerlerini
                                                     //bir string'e atayıp pencereler arası gecis yapabiliriz

    }
}
