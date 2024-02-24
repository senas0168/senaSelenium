package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chromedriver.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfanın konumunu ve boyutlarını yazdırın
        System.out.println("Sayfanın konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutları = " + driver.manage().window().getSize());

        //Sayfayı simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 sn bekleyip sayfayı maximize yapın
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanın konumunu ve boyutlarını maximize durumunda yazdırın
        System.out.println("Sayfanın konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutları = " + driver.manage().window().getSize());

        //sayfayı fullscreen yapın
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //sayfanın konumunu ve boyutlarını fullscreen durumunda yazdırın
        System.out.println("Sayfanın konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutları = " + driver.manage().window().getSize());

        //sayfayı kapatın
        Thread.sleep(2000);
        driver.close();
    }
}
