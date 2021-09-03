package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginSuccess() {
        openLoginForm();
        fillLoginForm("ololo_tester@gmail.com", "Ololo_Tester123");
        submitForm();
        Assert.assertTrue(isLogged());
    }

    @Test
    public void negativeLoginWrongPassword() {
        openLoginForm();
        fillLoginForm("ololo_tester@gmail.com", "OloloTester123");
        submitForm();
        Assert.assertFalse(isLogged());
    }

    @AfterMethod
    public void postCondition() {
        if (isLogOutPresent()) {
            logout();
        }

    }
}
