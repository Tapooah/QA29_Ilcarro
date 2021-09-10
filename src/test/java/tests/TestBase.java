package tests;

import application.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {
    protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        appManager.init();
    }

    @AfterClass
    public void tearDown() {
        appManager.stop();
    }
}
