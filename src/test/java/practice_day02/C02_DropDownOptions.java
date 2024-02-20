package practice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown 'dan "Baby" secenegind secin
    //sectiginiz option"1 yazdirin
    // dropdown daki optionlarin toplam savasanan 28* esit oldugunu test edin
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test02() {
        // https://www.amazon.com.tr/ sayfasina gidin
        driver.get("https://www.amazon.com.tr/");

        // dropdown 'dan "Baby" secenegind secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Bebek");

        //sectiginiz option"ı yazdirin,
        String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option = " + sectigimOption);

        // dropdown daki optionlarin toplam savasanan 28* esit oldugunu test edin
        List<WebElement> tumOptionlar = select.getOptions();
        int actualOptionSayisi = tumOptionlar.size();
        int expectedOptionSayisi = 21;
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);
    }
}
