package practice_day05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.security.Key;

public class P08_Faker extends TestBase {
    /*
                                     - FAKER -
              Faker class'i, adlar, telefon numaralari, adresler, SSN vb.
        gibi gerçek görünümlü verileri dinamik olarak olusturmaniza olanak tanir.
        Web uygulamanizin bunlara dogru bir sekilde kaydedecegini bildiginiz sürece,
        çogu zaman ad veya adres gibi bu degerterin ne oldugu umurunuzda olmaz ve faker kullanmak
        bu verileri modellemenize ve bu alanlar için simdiye kadar test çalistirması için yeni dinamik degerler olusturmaniza olanak tanir.
        Faker class'ini  kullanabilmeniz için mvn repository adresinden java faker kütüphanesini projemize eklememiz gerekmektedir.

     */

    @Test
    public void name() {
        //"https://demoqa.com/automation-practice-form" Adresine gidin
        waitFor(3);
        driver.get("https://demoqa.com/automation-practice-form");

        // Form doldurunuz
        waitFor(3);

        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.ARROW_RIGHT,Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB,
                "20 Jul 1980",Keys.ENTER,Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);
        WebElement dosyaSec = driver.findElement(By.xpath(" //input[@id='uploadPicture']"));

      // String dosyaYolu = "C:\\Users\\SENA\\Desktop\\some-file.txt";//dosyaya shift + sağ tık -> yol olarak kopyala'yı sec
        String anaYol = System.getProperty("user.home");//C:\\Users\\SENA\\
        String ortakYol = "\\Desktop\\some-file.txt";
        String dosyaYolu = anaYol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        WebElement adress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        adress.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR");
        waitFor(3);



        // Soyfayi kapatin
    }


}
