package day06;

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
    WebDriver driver;
    // Eger test sınıfında birden fazla method olusturulmussa, @Before kullanılır

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Given kullanıcı  https://testcenter.techproeducation.com/ sayfasındayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {


        // 1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        //2. Select objesi olustur
        Select yearDropdown = new Select(year);
        //3. Select object i kullanarak 3 farklı sekilde secim yapabilirim
        yearDropdown.selectByIndex(24); //SECENEK SIRASI 0 DAN BASLAR. 2000 yılı 25. sirada
        //dogum yılını, ayını ve gununu su sekilde secer : 2000, january,10

        //Ay secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//optional value degeri ile secim yapılabilir. january seceneginin value si 0

        //Gun secimi selectByVisibleTest ile secelim
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10"); //CASE SENSİTİVE

    }

    @Test
    public void printAllTest() {
// Tum eyalet isimlerini console a yazdıralım
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
//        for (WebElement eachState: stateList) {
//            System.out.println(eachState.getText());
//        }
        stateList.stream().forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionTest() {
// State dropdown ındaki secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);

       // WebElement varsayilanElement =stateDropdown.getFirstSelectedOption();
       // String varsayilanElementText = varsayilanElement.getText();

        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals("Select a State",varsayilanText);
    }
    @After
    public void tearDown(){
      driver.close();
    }


    /*
    1. What is Dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanılır.
    2. How to handle dropdown elements? Dropdown nasıl automate edilir ?
    -dropdown i locate ederim
    -select ohjesi olustururum
    -select ohjesi ile istedigim secenegi secerim
    NOT: select objesi olusturma nedenim, dropdownların Select classi ile olusturuması
    3.Tum dropdown seceneklerini nasl print ederiz?
    - tum dropdown elementlerini getOptions methodu ile listeye koyarız
    - sonra secenekleri loop ile yazdırabiliriz
    -ya da lambda ile print edebiliriz
    4. Bir secenegin secili oldugunu otomate etmek icin ne yapılır?
    Ornek : Gun olarak 10 u sectik ama ya secilmediyse ?
    getFirstSelectedOption() secili olan seceneği return eder
     */
}
