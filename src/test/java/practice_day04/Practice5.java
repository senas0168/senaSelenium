package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Practice5 extends TestBase {
    @Test
    public void test01() {

        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow =driver.getWindowHandle();

        //- youtube videosunu colistarinaz
        WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        //- Üc saniye calistiktan sonra saufaya yenileyiniz
        waitFor(3);
        driver.navigate().refresh();

        //- yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");

        //- iphone arataniz
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //- arama sonucu olarak sadece sonuc sayisana yazdaraniz
        String[] aramaSonuc = driver.findElement
                        (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().split(" ");
        System.out.println("Arama Sonuc Sayısı = " + aramaSonuc[0]);

        //- ilk sekmeye geri dönüp url'ini konsola yazdarolin
        driver.switchTo().window(ilkWindow);
        System.out.println("ilk window url' : " +driver.getCurrentUrl());

        //- ilk sekmeyi kapatalam
        driver.close();

        //- Sonra diger sekmeyide kapatalin
        //TestBase'deki @After notasyonu çalışacak
    }
}
