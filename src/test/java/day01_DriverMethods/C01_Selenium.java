package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Selenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        /*
    En temel haliyle otomasyon yapmak için
    Class'ımıza otomasyon için gerekli webdriver'in yerini göstermemiz gerekir
    bunun icin java kutuohanesinde System.setProperty() method'unu kullanırız
    ve method'un icine ilk olarak driver'i yazarız. İkinci olarak onun fiziki yolunu kopyalarız
     */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }


}
