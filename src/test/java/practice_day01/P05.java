package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
   static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {//ait+insert before after class seceneği
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        Thread.sleep(3000);
driver.get("http://www.google.com");
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(3000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
    }
    @Test
    public void test02() throws InterruptedException {
        Thread.sleep(3000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }
    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(3000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
         String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı : "+sonuc[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
    //BeforeClass ile driver 1 olusturun ve
    //Maximize Idin, 15 sn bekletin
    // https://www.google.com adresine gidin
    //arama kutusung "The God Father" yazip, cikan sonuc sayisini yazdirin
    // arama kutusuna "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    // arama kutusuna "Kill Bill" yazip, cikan sonue sayisini yazdirin
    //AfterClass ile kapatin
}
