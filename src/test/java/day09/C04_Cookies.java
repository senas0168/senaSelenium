package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com.tr/");
        waitFor(2);
        //1. toplam cookie sayisini bul
        Set<Cookie> allCookies =driver.manage().getCookies();// toplam cerez sayısı
        int cookieSayisi= allCookies.size();
        System.out.println("Sayfada " + cookieSayisi+"adet cookie var");
        //3. Bir Cookie yi ismiyle bul

        //tum cookie leri yazdıralım
       // allCookies.stream().forEach(t-> System.out.println(t.getName()));

        for (Cookie eachCookie : allCookies){
            System.out.println("COOKİE : "+eachCookie);//COOKİE NIN TAMAMINI(TUM BİLGİLERİNİ) YAZDIR
            System.out.println("COOKİE İSİMLERİ : "+eachCookie.getName());
        }
        System.out.println("COOKİEYİ İSMİYLE CAGİRİYORUM : "+driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam","antep-fistikli-cikolata");//cookie olustur
        driver.manage().addCookie(favoriCookiem);//sayfaya yeni cookie ekle
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());//cookie sayisini arttir
        waitFor(1);

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKİELERİ SİLDİM. YENİ COOKİE SAYİSİ : "+ driver.manage().getCookies().size());
    }
}
