package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_JSExecutor_Click extends TestBase {
    @Test
    public void name() {
        //clickByJSTest

        //amazon.tr ana sayfasina git
        driver.get("https://www.amazon.com.tr/");
        waitFor(3);

        //moda elementine tikla
        clickByJS(driver.findElement(By.xpath("(//a[@class='nav-a  '])[7]")));
        waitFor(3);
        //Cikan sayfayinin URL inin "https://www.amazon.com.tr/gp/browse.html?node=12466553031&ref_=nav_cs_fashion" oldugunu test et
        Assert.assertEquals("https://www.amazon.com.tr/gp/browse.html?node=12466553031&ref_=nav_cs_fashion", driver.getCurrentUrl());


    }
}
