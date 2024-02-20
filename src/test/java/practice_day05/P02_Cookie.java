package practice_day05;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookie extends TestBase {
    @Test
    public void test01() {

/*
    Cookies(Cerezler)
    "Cookie" ler, bir web sitesi tarafandan tarayacaya depolanan küçük veri parçaciklarzair.
            Tarayica, herhangi bir web soyfosing gittiginde, o sayfanin cookie Lerini saklar ve
            daha sonra o soyfayo geri döndügünde, o cookie leri tekrar gönderir. Bu sayede, web sitesi,
            kullanicinin daho önce o sayfada ne yaptagina veya ne seçtigini hatırlayabilir.
    */
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com/");
        waitFor(5);
        //Sayfadaki cookie lerin sayssina yozdaranaz
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies sayısı = " + cookies.size());

        //Sayfadaki cookie lerin isim ve degerterini yazdaranaz
        for (Cookie c:cookies) {
            System.out.println(c.getName() + ":" + c.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayssina ve isimlerini yazdaranaz
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("cookielerin sayısı = " + cookies2.size());
        for (Cookie w:cookies2) {
            System.out.println(w.getName() + ":" + w.getValue());
        }
        // olusturdugumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());

    }

}
