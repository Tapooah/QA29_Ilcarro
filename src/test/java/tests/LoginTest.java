package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void negativeLoginWrongPassword() {

        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("pablus@gmail.com", "Pablus_tester123");
        appManager.getUserHelper().submitForm();
        Assert.assertFalse(appManager.getUserHelper().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("pablus@gmail.com").withPassword("Pablus_tester123");

        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm(user);
        appManager.getUserHelper().submitForm();
        Assert.assertTrue(appManager.getUserHelper().isLogged());
    }
    @Test
    public void loginSuccess() {
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("pablus@gmail.com", "Pablus_tester123");
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
