package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class P10_FluentWait extends TestBase {
    /*
                                     - Fluent Wait -
Selenium'da Fluent Wait, web sürücüsünün bir kosulu beklemesi için maksimum süreyi ve "ElementNotVisibleException"
exception'ını atmadan önce kosulu kontrol etmek istediğimiz siklaga tanımlanak için kullanilir.
Nesne bulunana veya zaman aşımı gerçeklesene kadar düzenli aralıklarala web elementini kontrol eder.
Bir elemanin farklı zaman aralıklarında yüklendigi bir senaryo düsünelim.
Öge 10 saniye, 20 saniye veya daha uzun bir süre içinde yüklenebilir.
Bu durumdo 20 soniyelik Explicit wait tanimlarsak bir exception atmadan önce belirtilen süreye kadar bekleyecektir
Bu tür senaryolarda, Fluent Wait ogeyi bulana kadar veya son zonanlayici bitene kadar farkli frekansta bulmaya
calısacagından, kullanımı ideal olacaktir
Syntax:
Wait<Webdriver> wait = new Fluentwait<>(driver)
.withTimeout (Duration.ofSeconds (30))
pollingEvery(Duration.ofSeconds(3))
.ignoring (NoSuchElementException.class);//Eger element bulunmazsa NoSuchElementException hatasını yok sayar
 */

    @Test
    public void name() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasina gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me, to open an ... butonuna basalim
        WebElement waitButton = driver.findElement(By.xpath("//*[@id='alert']"));
        waitButton.click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//max bekleme sure
                .pollingEvery(Duration.ofSeconds(2));//hangi sıklıkla beklemesı gerektıgını belirleriz
        wait.until(ExpectedConditions.alertIsPresent());//alert cıkana kadar bekle

        //Cıkan alert'i kapatalım
        driver.switchTo().alert().accept();
    }






}
