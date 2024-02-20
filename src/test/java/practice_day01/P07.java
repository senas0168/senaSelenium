package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    //1 https://www.google.com/ adresine gidin
//2 Sayfa basliginin "Google" ifadesi icerdigini test edin
//3 Arama cubuguna "Nutella" yazip aratin
//4 Bulunan sonuc sayisini yazdirin
//5 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
//6 Sayfayi kapatin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        //1 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //2 Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //3 Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //4 Bulunan sonuc sayisini yazdirin
        //*[@id='result-stats']
        String[] sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc =sonucSayisi[1];
        System.out.println("Arama Sonuc Sayısı : "+sonuc);

        //5 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("\\D",""); //ReplaceAll methodu ile \\D'i kullanarak bütün noktalama işaretlerini hiçlikle degiştir
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);//Integer.parseInt(sonuc)--> String olan sonuc u int a cevirdi

        //6 Sayfayi kapatin
        driver.close();


    }
}
