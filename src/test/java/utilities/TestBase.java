package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.seconds;

public abstract class TestBase {
    // TestBase i abstract yapmamızın nedeni bu sınıfın objesini olusturmak istemiyorum
    //TestBase testBase = new TestBase(); -> YAPILAMAZ
    //Amacım bu sınıfı extend etmek ve icindeki hazır methodları kullanmak


    //driver objesini olustur. Driver ya public ya da protected olmalı. Sebebi child classlarda gorulebilir olması
    protected static WebDriver driver;

    //setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //-----------------------------------------------------

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ExtentReports/htmlreport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gozukmesını ıstedıgımız bılgıler ıcın
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Erol");
        extentHtmlReporter.config().setDocumentTitle("Test Sonucu");
        extentTest = extentReports.createTest("Extent Tests", "Test Raporu");

    }

    //tearDown
    @After
    public void tearDown() {

        //   waitFor(5);
        // driver.quit();
    }

    //MULTİPLE WİNDOW
    //          1 parametre alır
    //          Ornek:
    //         driver.get("https://the-internet.herokuapp.com/windows");
    // switchToWindow("New Window");
    // switchToWindow("The Internet");
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }

        }
        driver.switchTo().window(origin);

    }

    //windowNumber sıfır(0)'dan baslıyor
    //index numarasını parametre olarak alır
    // ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*
            HARD WAİT:
            @param : second
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //ACTİONS_RİGHT CLİCK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //ACTİONS_DOUBLE CLİCK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //ACTİONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
        //      Actions actions =new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //ACTİONS_SCROLL_DOWN
    public static void scrollDownActions() {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //ACTİONS_SCROLL_UP
    public static void scrollUpActions() {
        //        Actions actions =new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //ACTİONS_SCROLL_RİGHT
    public static void scrollRightActions() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //ACTİONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //ACTİONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
        //        Actions actions =new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //ACTİONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
        //        Actions actions =new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }

    // DYNAMİC SELENIUM WAITS:
    //================Explicit Wait===================//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //COK KULLANILMAZ
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }

        }
    }

    //This can be used when a new page opens. Yeni sayfaya gecişlerde kullanılabilir
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");

        }
    }

    //================Fluent Wait===================//
    //params: xpath of teh element , max timeout in seconds,polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchMethodException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    //SCREENSHOTS
    public void takeScreenShotOfPage() throws IOException {
        //1.Take Screenshot
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //2. Save screenshot
        //getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //Path of screenshot save folder                folder / folder      /file name
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    //SCREENSHOT
    //@params:Webelement
    //takes screenshot
    public void takeScreenShotOfElement(WebElement element) throws IOException {
        //1.Take Screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
        //2. Save screenshot
        //path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));


    }

    //SCROLLINTOVİEWJS
    //@param : WebElement
    //Verilen webelementin uzerine kaydırır
    public void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //SAYFANIN EN ALTINA IN
    //Bu method ile sayfanın en altına ınebiliriz
    public void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //Bu method ile sayfanın en üstüne çıkabiliriz

    public void scrollTopJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    //Bu metot ile belirli bir elemente JS executor ile tıklanabilir
    public void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    //girmiş oldugum metnı elemente yazdırır
    //bu method sendKeys metotuna bir alternatiftir
    //sendKeys oncelikli tercihimizdir
    public void typeWithJS(WebElement element, String metin) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + metin + "')", element);
    }

    //input elementindeki degerleri(value) al
    //Belirli bir WebElement'in id degerini String olarak alır ve value attribute degerini String olarak dondurur
    //return
    // document HTML'E GİT
    // .getElementById('" + idOfElement + "') ID Sİ VERİLEN ELEMENTİ BUL
    // .value") VALUE ATTRİBUTE UNDAKİ DEGERİ BUL
    // .toString(); STRİNGE CEVİR
    public void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("Kutudaki value = " + text);
        //NOT: document.querySelector("p"); -> p tagli ilk elementin degerini return eder
        // document.querySelector(".example").value; -> CSS DEGERİ KULLANILABİLİR
        // document.querySelector("#example").value; -> CSS DEGERİ KULLANILABİLİR

    }


    /*
    1) <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> pom.xml'e yuklemek
    2)Eger extentReport almak istersek ilk yapmamız gereken ExtentReport class'ından bir obje olusturmak.
    3)HTML formatında duzenlenecegı ıcın ExtentHtmlReporter class'ından obje olusturmak.
     */
    protected ExtentReports extentReports;//Raporlamayı baslatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu html formatında duzenler
    protected ExtentTest extentTest;//Test aşamalarına extentTest objesi ile bilgi eklerız


}


