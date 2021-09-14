package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void negativeLoginWrongPassword() {
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("ololo_tester@gmail.com", "OloloTester123");
        appManager.getUserHelper().submitForm();
        Assert.assertFalse(appManager.getUserHelper().isLogged());
    }


    @Test
    public void loginSuccess() {
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("ololo_tester@gmail.com", "Ololo_Tester123");
        appManager.getUserHelper().submitForm();
        Assert.assertTrue(appManager.getUserHelper().isLogged());
    }



    @AfterMethod
    public void postCondition() {
        if (appManager.getUserHelper().isLogOutPresent()) {
           appManager.getUserHelper().logout();
        }

    }
}
