package practice_day05;

import org.junit.Test;
import utilities.TestBase;

public class P01_BasicAut extends TestBase {
    @Test
    public void test01() {
/* Basic Authentication(Temel Kimlik Doğrulama)
    Basic Authentication, HTTP protokolü üzerinden bir web sayfasina erisim icin kullanılan bir
    güventik yöntemidir. Bu yöntem, kullanici adi ve parola gibi kimlik bilgilenini gönderen bir
    istemci tarafandan kullanılir ve sunucu tarafindan dogrulanır. Eder kimik bilgileni dogru ise,
     sunucu istemciye erisin izni verin. Eger kimlik bilgileri yanlıs ise, sunucu istemciye erisim izni vermez.
          Basic Authentication genellikle özel veya yönetim tarafindan korunan web siteleri icin kullanilir.
    Örnek olarak, sirket ici yönetim arayüzleri, veritabana yönetim sistemleri, sanat makine yönetim arayüzleri
    gibi siteler kullanabilir.
    Bu tür sitelerde, kullanacilarin sadece yetkilendirilmis kullanicilar tarafindan erisilebilecegi garanti
    edilmek istenebilir. Ayraca bazi bölgesel / Ülke veya alan spesifik hizmetlerde kullanalmakta,
     örnegin bankalarin online bankocalik hizmetleri, soglik hizmetleri, kamu hizmetleri, e-devlet hizmetleri gibi.
*/
        //http://httpbin.org/basic-auth/foo/bar adresine gidiniz
        driver.get("http://httpbin.org/basic-auth/foo/bar");

        //Username: foo
        // password : bar
        driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");
        // Yukardaki venileri kullanarak güvenligi geçin

    }

}
