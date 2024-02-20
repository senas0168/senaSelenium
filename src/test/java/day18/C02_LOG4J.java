package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.TestBase;

public class C02_LOG4J {

    //3. Logger object olustur:
    //private static Logger logger = LogManager.getLogger(Demo1.class.getName());
    //4. Logger fonksiyonuyla istenilen fonksiyonu kullan
    //logger.debug ("Debug logger");
    //logger.info("Info logger");
    //logger.error("Error logger");
    //Logger.fatal("Fatal Logger");

    private static Logger logger = LogManager.getLogger(C02_LOG4J.class.getName());

    @Test
    public void log4JTest() {
// logger objesi ile yazdırma işlemını yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }
}
