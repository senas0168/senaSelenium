package day01_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageWindowSet {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.vhrome.driver", "src/resources/drivers/chromedriver.exe");
        driver.get("https://www.amazon.com");
        System.out.println("Saayfa Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfa Olculeri = " + driver.manage().window().getSize());
        driver.manage().window().setPosition(new Point(80,0));
        driver.manage().window().setSize(new Dimension(800,600));
        driver.close();
    }
}
