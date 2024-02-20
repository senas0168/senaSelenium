package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {

        //- ebay sayfasina gidiniz
        driver.get("https://www.ebay.com/");

        //- electronics bölümüne tiklayin1z
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genisligi 225 ve Uzunlugu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanan sayfo bastigina yazdirolan
        for (int i = 0; i < 24; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            System.out.println(i+". başlık : "+driver.getTitle());
            Thread.sleep(2000);
        }


    }

    @AfterClass
    public static void afterClass() throws Exception {
        //- sayfaya kopatalim
        driver.close();
    }
}
