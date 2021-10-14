package tests;

import application.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestBase {
    protected static ApplicationManager appManager = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start method: " + m.getName());
    }

    @AfterMethod
    public void endLogger(Method m) {
        logger.info("End of test: " + m.getName());
    }

    @BeforeSuite
    public void setUp() {
        appManager.init();
    }

    @AfterSuite
    public void tearDown() {
        appManager.stop();
    }
}
