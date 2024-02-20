package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    //Method: hoverOver() and test the following scenario:
    //Amazon a gidelim https://www.amazon.com.tr/


    @Test
    public void hoverOverTest() {
        driver.get("https://www.amazon.com.tr/");

        //"Account & Lists" menüsüne git uzerinde bekle -mouse over- hover over(havada durmak, beklemek)
        //1.ACTİONS OBJESİ
        Actions actions = new Actions(driver);

        //2.ELEMANI BUL
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);
        //3.UYGUN ACTİONS METHODUNNU KULLAN. EN SON PERFORM KULLANMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(1);

        //"Account" secenegine tikla
        driver.findElement(By.linkText("Hesabım")).click();

        // Acilan sayfanin Title in "Hesabım" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Hesabım"));


    }
}
