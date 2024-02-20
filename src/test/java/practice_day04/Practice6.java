package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class Practice6 extends TestBase {
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... baslaginan altandaki Text Box'a "Techproeducation" yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
         WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        // TextBox'in altinda bulunan "Elemental Selenium" linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();// (   refresh()  methodu da olur )ilk once iframe den çıkmalıyız
        WebElement elementalSeleniumLinki =driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine taklayan
        elementalSeleniumLinki.click();
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Acılan pencerelerin handle degerleri : "+ windowHandles);
        driver.switchTo().window(windowHandles.get(1));

        /*
                Set<String> allWindowHandles = driver.getWindowHandles();//{window1Handle,window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles) {
            //eger listedeki id window1 e esit degilse, otomarik olarak window2 ye esittir
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);//Buradaki eachHandle window2 handle ına esittir
                break;
            }


        }
         */
        // Açalon sayfada sayfa baslagana yazdaraniz
        System.out.println("Elemental Selenium : " + driver.getTitle());

        // External resources baslaga altandaki "The Team Behind" Linkinin gorunur oldugunu test edin
        WebElement externalResourcesLinki = driver.findElement(By.xpath("//*[text()='The Team Behind']"));
        Assert.assertTrue(externalResourcesLinki.isDisplayed());

        // External resources linkine taklayan
        System.out.println("-----------------------------------------------");
        externalResourcesLinki.click();
        List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));

        // Açalan sayfada sayfa baslagını yozdaranaz
        System.out.println("Source Labs Sayfa Baslıgı = " + driver.getTitle());

        // ilk sekmeye geri donelin ve url'ini yazdaralan
        driver.switchTo().window(windowHandles2.get(0));
        System.out.println("Sayfa Url'i = " + driver.getCurrentUrl());

        // ilk sekneyi kapatalin
        driver.close();
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println(driver.getCurrentUrl());
    }

}

