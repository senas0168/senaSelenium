package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2 Add Element butonuna basin
        Thread.sleep(3000);
        // WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        //                  <button onclick="addElement()">Add Element</button>
        WebElement addButtonT = driver.findElement(By.xpath("//*[text()='Add Element']"));
        //Xpath kullanımında locate edeceğimiz webelement text' e sahipse yukarıdaki şekilde kullanabiliriz
        addButtonT.click();

        //3 Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        if (deleteButonu.isDisplayed()) {//Bir webelementin görünür olup olmadıgınız isDisplayed() methodu ile bakarız
            System.out.println("Test PASSED");
        } else System.out.println("Test FAİLED");

        //4 Delete tusuna basin
        Thread.sleep(3000);
        deleteButonu.click();

        //5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveEYazisi = driver.findElement(By.xpath("//h3"));
        if (addRemoveEYazisi == null) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAİLED");
    }
}
