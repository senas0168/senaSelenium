package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {
    @Test
    public void ScreenshotOfSpecificElements() throws IOException {
        //Techpro ya git
        driver.get("https://techproeducation.com/");


        //sosyal medya elemanlarını goruntusunu al
        //1. ekran goruntusunu cek
        WebElement sosyalMedyaIconları = driver.findElement(By.xpath("//div[@class='toolbar-sl-share']"));
        File image =sosyalMedyaIconları.getScreenshotAs(OutputType.FILE);
        //2.goruntuyu kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //Path of screenshot save folder                folder / folder      /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        waitFor(3);
        //LOGONUN EKRAN GORUNTUSUNU AL
        takeScreenShotOfElement(driver.findElement(By.xpath("(//img[@alt='TechPro Education'])[1]")));;
    }
}
