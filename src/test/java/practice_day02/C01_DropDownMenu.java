package practice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {
    // https://www.amazon.com.tr/ sayfasina gidin
    // dropdown' dan "Books" secenegini secin
    // arama cubuguna "Java" aratin
    // arama sonuclarinin Java icerdigini test edin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        //  driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com.tr/ sayfasina gidin
        driver.get("https://www.amazon.com.tr/");

        // dropdown' dan "Kitaplar" secenegini secin

        //dropdown 3 adımda handle edilir
        //1- locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        //2-Select objesi olusturmalı
        Select select = new Select(ddm);

        //3-opsiyon secilir
        select.selectByVisibleText("Kitaplar");
        //select.selectByValue("search-alias=stripbooks");
        //select.selectByIndex(9);

        // arama cubuguna "Java" aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);


        // arama sonuclarinin Java icerdigini test edin
       WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String aramaSonucYazisi = aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));



        /*
        Kaç tane locate turu vardır?
        8 tanedir
        id, name,classname,tagname,link, linktest, partiallinktest, xpath, csslocator (en basta id yi denerim)
         */

    }
}
