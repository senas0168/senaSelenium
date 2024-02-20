package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test04() {
        // https://amazon.com.tr adresine gidiniz
        driver.get("https://amazon.com");
        String window1Handle = driver.getWindowHandle();

        // sag ust bolunde bulunan dil secenek menusunun acilmasi icin mause u bu menunun ustune getirelin

        WebElement dil = driver.findElement(By.id("icp-nav-flyout"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dil).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();

        // United States dropdown undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        //Drop down opsiyon listesi "Go to website" butonuna basmamıza engel oldugu icin
        // herhangi bir yere clicl yapıp dropdown opsiyon listesinin toparlanmasını sagladık

        driver.findElement(By.xpath("//span[.='Changing country/region website']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();


//        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
//        System.out.println("Acılan pencerelerin handle degerleri : " + windowHandles);
//        driver.switchTo().window(windowHandles.get(1));

        Set<String> allHandles = driver.getWindowHandles();

        String window2Handle = "";
        for (String eachHandle : allHandles) {
            if (!eachHandle.equals(window1Handle)) {
                window2Handle = eachHandle;
            }
        }
        System.out.println(allHandles);
        System.out.println(window1Handle);


        driver.switchTo().window(window2Handle);
        waitFor(3);
        // acilan yeni sayfadanin Title inin Elektronik icerdigini test ediniz
        String baslik = driver.getTitle();
        Assert.assertTrue(baslik.contains("Amazon"));

    }
}
