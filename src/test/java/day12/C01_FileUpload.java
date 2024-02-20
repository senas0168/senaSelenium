package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {
    //Tests packagenin alting bir class olusturun: C05_UploadFile
    @Test
    public void fileUploadTest() {
        // https://the-internet.herokuapp.com/upload adresine gidelin
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonung basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        /*
        chooseFileButton una yuklemek istedigim dosyanın path ını gondererek dosyayı sectim
         */
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

        //Upload butenuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
       String uploadedYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadedYazisi);
        waitFor(5);
    }

    //Yuklemek istediginiz dosyayi secelim.
}
