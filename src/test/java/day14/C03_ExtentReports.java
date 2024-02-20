package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {
    //HATIRLAMAMIZ GEREKEN 3 DEGISKEN
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter  extentHtmlReporter;
    protected static ExtentTest extentTest;
    @Test
    public void extentReportsTest() {
        //REPORT PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports"+currentTime+"html_report.html";

        // creatıng HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // creatıng extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        //************************RAPORU CUSTOMIZE EDEBİLİRİZ************************

        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application ","TechPro Education");
        extentReports.setSystemInfo("Browser ","Chrome ");
        extentReports.setSystemInfo("Takim ","Eagles ");
        extentReports.setSystemInfo("Epic ","Odeme Sayfası ");
        extentReports.setSystemInfo("Sprint Numarası ","Sprint-145");
        extentReports.setSystemInfo("QA ","Ahmet ");

        //************************EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBİLİRİZ************************

        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Reggression Test Sonucu");


        //************************RAPORU AYARLARI BITTI ************************
        extentReports.attachReporter(extentHtmlReporter);


        //Extent Test objesini olusturduk

        extentTest = extentReports.createTest("Extend Report Login Test","Smoke Test Raporu");

        //TUM AYARLAR BİTTİ. EXTENT TEST OBJESİ İLE LOGLAMA(RAPORA YAZDIRMA) ISLEMINI YAPABİLRİÖ
        extentTest.pass("Kullanıcı Ana Sayfaya gider");
        driver.get("https://techproeducation.com/");

        //LMS SAYFASINA GİDELİM
        extentTest.pass("Kullanıcı LMS sayfasına gider.");
        driver.findElement(By.xpath("//a[@class='px-2 py-1 mrb ggpop fa-solid fa-user fa-xl']")).click();

        //TEST BİTTİ
        extentTest.pass("TEST BASARIYLA GERCEKLESTİ");

        //RAPORU GOSTER. RAPORUN OLUSMASI ICIN BU ADIM ZORUNLUDUR
        extentReports.flush();

        //    https://lms.techproeducation.com/
               //a[@class='banner-btn bdrs3']


    }
}
