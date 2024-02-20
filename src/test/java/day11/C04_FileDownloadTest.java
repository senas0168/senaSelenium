package day11;

import io.github.bonigarcia.wdm.online.GoodVersions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {
        //2.https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //3.b10 all test cases dosyasini indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);
        //4.Dosyanin basarıyla indirilip indirilmedigini test edelim
        String filePath = System.getProperty("user.home") +"/Downloads/b10 all test cases, code.docx";
        boolean indirildimi =Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);

    }
}
