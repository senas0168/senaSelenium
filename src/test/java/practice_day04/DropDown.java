package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DropDown extends TestBase {
    @Test
    public void test01() {

        // Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");

        //Dropdown menuyu yazdıralım
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for  (WebElement w :select.getOptions()) {
            System.out.println(w.getText());
        }
        //Dropdown menuden bebek i secelim
        //Arama bölumunden milk aratalım

        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Bebek",
                Keys.TAB,"Süt",Keys.ENTER);

        //Select select = new Select(dropdown);


    }

}
