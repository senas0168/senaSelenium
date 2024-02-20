package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//form[@class='search-formm']")).//org.openqa.selenium.NoSuchElementException: no such element:
                sendKeys("QA" + Keys.ENTER);

    }
}
