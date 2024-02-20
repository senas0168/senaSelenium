package practice_day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    //If Value kullanarak Option 2 seçin ve sectiginiz option'ı yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option 'u yazdırın
    // Túm option Lara yazdırın
    // dropdown'daki optionlarin toplan sayısının 3'e esit oldugunu test edin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //her locatorun yüklenmesi için gereken max süreyi belirtir
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        String sectigimOptionIndex = select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option Index = " + sectigimOptionIndex);

        Thread.sleep(3000);


        //Value kullanarak Option 2 seçin ve sectiginiz option'ı yazdırın
        select.selectByValue("2"); // value sı 2'ymis -->  <option value="2" selected="selected">Option 2</option>
        String sectigimOptionValue = select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option Value = " + sectigimOptionValue);

        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option 'u yazdırın
        select.selectByVisibleText("Option 1");// websitesinde nasıl görüyosak öyle yazıcaz
        String sectigimOptionVisibleText = select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option VisibleText = " + sectigimOptionVisibleText);

        Thread.sleep(3000);

        // Tüm option'ları yazdırın
        List<WebElement> tumOpsiyonlar = select.getOptions();
        int sayac = 1;
        for (WebElement each : tumOpsiyonlar) {
            System.out.println(sayac + ". OPTİON : " + each.getText());
            sayac++;
        }
        // dropdown'daki optionlarin toplan sayısının 3'e esit oldugunu test edin
        int actualOptionSayisi = tumOpsiyonlar.size();
        int expectedOptionSayisi = 3;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
}
