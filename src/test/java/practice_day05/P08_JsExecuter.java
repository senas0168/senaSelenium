package practice_day05;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P08_JsExecuter extends TestBase {
    /*
                                  -- JavascriptExecutor --
-- ID'Si ILE LOCATE
WebElement element = (WebElement)
                    js.executeScript("return document.getElementById('twotabsearchtextbox');")

                      js.executeScript("return document.getElementById('twotabsearchtextbox");") kodu, JavaScriptExecutor
        araciladiyla belirti bir ID degerine sahip bir web elementini locate etmek igin kullanilan bir koddur.
        Bu kod, JavaScriptExecutor aracalagayla tarayacada calıstırılır ve getelementById()
        metodu kullanilarak 'twotabsearchtextbox' ID degerine sahip bir elementi locate eder.
        Bu kodun döndürdügü sonuc, locate edilen elementi temsil eden bir WebElement nesnesidir.
        Bu WebElement nesnesi, daha sonra Selenium komutları ile bu element üzerinde islem yapmak için kullanalabilir.

        -- XPATH ILE LOCATE
        WebElement element = (WebElement) js.executeScript
                ("return document.evaluate(\"//*[@id='twotabsearchtextbox']\",  " +
                         "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ). singleNodeValue;");

        -- CSS SELECTOR ILE LOCATE
        WebElement element = (WebElement)
                 js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");

     */

    @Test
    public void name() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //  Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com.tr/");

        //        Arama bölümÜnde selenium aratanaz
        WebElement searchBox =(WebElement)
                 js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'",searchBox);
        searchBox.submit();

        //        Back to top bolümüne kadar scroll yapinaz
        //WEB ELEMENTI CLASSNAME ILE SCROLL ETTİK
        WebElement backToTop =(WebElement)
                js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop);
        waitFor(3);
        //        Back to top bölümüne tiklayinaz
        js.executeScript("arguments[0].click();",backToTop);
    }



}
