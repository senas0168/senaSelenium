package day18;

import org.junit.Test;
import utilities.TestBase;

public class C01_JSExecutor_GetValue extends TestBase {
    @Test
    public void getValueTest() {

        //1) getValue Test metotu olustur
        //2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        //3)Tarih kismindaki Yazili metinleri al ve yazdir
        getValueByJS("hotelDates");

    }
}
