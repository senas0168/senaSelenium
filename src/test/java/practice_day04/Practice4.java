package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Practice4 extends TestBase {
    @Test
    public void test01() {
        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayısı: "+iframe.size());

        // ilk iframe'deki (Youtube) play butonuna tıklayiniz.
        WebElement frame = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        waitFor(3);
        // ilk iframe'den cikip and sayfaya dönünüz
        driver.navigate().refresh();

        // ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html
        //tiklayiniz

        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }

}
