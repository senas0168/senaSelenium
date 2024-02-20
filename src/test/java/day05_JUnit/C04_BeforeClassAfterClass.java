package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.time.Duration;

public class C04_BeforeClassAfterClass {
/*
@BeforeClass ve  @AfterClass notasyonları sadece static method'lar icin calısır
@BeforeClass ve @AfterClass kullanırsak olusturfugumuz @Test methodlarının hepsini aynı anda calıstırıp
en son @AfterClass'ı çalıstırırız
        Ama sadece @Before ve @After kullanırsak her test icin  @before ve @after'ı kullanır.
 */
    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalıştı");

    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştı");
    }
    @Before
    public void setUp001(){
        System.out.println("Her Test'ten önce çalışır ");
    }
    @After
    public void teardown01(){
        System.out.println("Her Test'ten sonra çalışır ");
    }
    @Test
    public void test01(){
        System.out.println("İlk Test");
    }
    @Test
    public void test02(){
        System.out.println("İkinci Test");
    }
    @Test
    @Ignore//Eger bir testi calıstırmak istemezsek bu sekilde kullanabiliriz
    public void test03(){
        System.out.println("Üçüncü Test");
    }
}
