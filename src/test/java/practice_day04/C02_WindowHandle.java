package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test02() {
        // 1- https://www.amazon.com.tr seyfasina gidelim
        driver.get("https://www.amazon.com.tr");
        String sayfa1Handle = driver.getWindowHandle();

        // 2- url"in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3 - yeni bir pencere acip https://www.bestbuy.com sayfasina gidelin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String sayfa2Handle = driver.getWindowHandle();

        // 4- title in 'Best Buy' icerdigina test edelin
        String baslikBestBuy = driver.getTitle();
        Assert.assertTrue(baslikBestBuy.contains("Best Buy"));

        // 5 - ilk sayfaya (amazon) donup sayfada java aratalam
        driver.switchTo().window(sayfa1Handle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinan 'Java' icendigina test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucuStr = aramaSonucu.getText();
        System.out.println(aramaSonucuStr);
        Assert.assertTrue(aramaSonucuStr.contains("Java"));

        // 7- ikinci sayfaya (bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);

        // 8- Logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
