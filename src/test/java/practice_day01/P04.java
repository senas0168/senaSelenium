package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButonu = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i <100; i++) {
            addButonu.click();
        }

        // 100 defa basıldıginı test ediniz
        List<WebElement> deleteButtonu = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteButtonu.size());

        // 90 defa delete butonuna basınız
        for (int i = 0; i <90 ; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }
        // 90 defa basıldıginı dogrulayıniz
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanDeleteButton = deleteButtonu.size()-90;
        Assert.assertEquals(kalanDeleteButton,deleteButtonList.size());

        // Sayfaya kapatınız
        driver.quit();
    }


}
