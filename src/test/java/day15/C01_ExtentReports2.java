package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 extends TestBase {
    //HATIRLAMAMIZ GEREKEN 3 DEGISKEN
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter  extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentReportsSetUp() throws Exception {
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


    }

    @Test
    public void extentReportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BİLGİLENDİRME NOTU");
        extentTest.fail("FAİLED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESSAJI");
        extentTest.fatal("COKUS HATASI");

    }

    @AfterClass
    public static void extentReportsTearDown() throws Exception {
        extentReports.flush();

    }
}
