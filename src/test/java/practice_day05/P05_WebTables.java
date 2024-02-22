package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P05_WebTables extends TestBase {
    @Test
    public void name() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelin
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altandaki tablodaki otel bilgilerini yazdariniz
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelBilgileri.forEach(t-> System.out.println(t.getText()));
        //Demo Table altindaki otel bilgileri olan tablodan Height degers 601m otan otelin bilgilerini yozdarinaz
        int row=1;
        for (WebElement w: otelBilgileri) {
            if (w.getText().contains("601m")){
                System.out.println("Tablodaki "+row+" .satırdaki otel bilgileri : "+w.getText());
            }
            row++;

        }
        //Bütün Height bilgiterini yozdaranaz
        List<WebElement> heightBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heightBilgileri.forEach(t-> System.out.println(t.getText()));

        //Otel uzunluklarinan hepsini toplayaniz
        List<String> list = new ArrayList<>();
        for (WebElement q:heightBilgileri) {
        list.add(q.getText());
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).replace("m",""));
        }
        list.forEach(System.out::println);

        int toplam =0;
        for (String s:list){
            toplam+=Integer.parseInt(s);

        }
        System.out.println("Otellerin toplam uzunlugu = "+toplam);


        //Bir method ile satir ve sutun bilgilerini cagaralim
        tabloSatirSutun(3,4);

    }

    private void tabloSatirSutun(int satir, int sutun) {
        System.out.println(satir+" . satir "+sutun+ " . sutun bilgisi : "+
                driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr["+satir+"]//td["+sutun+"]")).getText());
    }


}
