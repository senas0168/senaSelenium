package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // some-file.txt dosvasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        // dosyanin basariyla indiralip indictlmedigini test edelim (dosya downloads a indiralecektir)

        //         "C:\Users\SENA             \Downloads\some-file.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu2 = farkliKisim+ortakKisim;

        //String dosyaYolu = "C:\\Users\\SENA\\Downloads\\some-file.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));



    }
}
