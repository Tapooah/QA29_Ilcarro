package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    //click sing up
    //fill reg form
    //submit click

    @BeforeMethod
    public void preCondition() {

    }

    @Test
    public void registrationTest() {

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm("Ololo", "Tester", "ololo_tester"+i+"@gmail.com", "Ololo_Tester123");
        appManager.getUserHelper().checkPolicy();
        appManager.getUserHelper().submitForm();

    }

    @Test
    public void regTestNegative() {

    }

    @AfterMethod
    public void postCondition() {

    }
}
