package day07;

import com.fasterxml.jackson.core.json.PackageVersion;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    -Utilities tekrar kullanacagımız classları koydugumuz paketin adıdır
    -TestBase
    -Driver -> Sonra
    -ExcelUtil -> Sonra
    -Configuration -> Sonra
    -Utilities paketinde Test case ler yazılmaz
    -Sadece tekrar kullanılabilecek destek sınıfları(support class) olusturulur.
    -Bu support classlar test caselerin yazılmasını hızlandırır
     */
    @Test
    public void test1(){
        //techproeducation ana sayfasına git
        driver.get("https://www.techproeducation.com");

        // ve title ın IT Programs kelimesini içerdigini test et
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("IT Programs"));

    }
}
