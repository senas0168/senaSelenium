package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest() {
        //EN FAZLA SURUKLEMEK İCİN KULLANILAN METHOD BUDUR
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENT İFRAMEIN İCİNDE
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        //dragAndDrop() sürükleme işlemini gerçekleştirir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak, hedef).perform();
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENT İFRAMEIN İCİNDE
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        //dragAndDrop() sürükleme işlemini gerçekleştirir
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).//kaynagı tut
                moveToElement(hedef).//hedefe koy
                release().//KAYNAGI BIRAK
                build().//onceki methodların ilişkisini kur/guclendır. KULLANILMASI TERCİH EDİLİR.
                perform();//işlemi gercekleştir
    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENT İFRAMEIN İCİNDE
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        //dragAndDrop() sürükleme işlemini gerçekleştirir
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).
                moveByOffset(430,30).
                build().
                 perform();
    }
}
