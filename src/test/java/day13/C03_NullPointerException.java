package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {
    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest() {
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException
        

    }

    @Test
    public void nullPointerExceptionTest2() {
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }
}
