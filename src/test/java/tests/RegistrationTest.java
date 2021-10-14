package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition() {

    }

//    @Test
//    public void registrationTest() {
//
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//
//        appManager.getUserHelper().openRegistrationForm();
//        appManager.getUserHelper().fillRegistrationForm("Pablus", "Yatonu", "pablus" + i + "@gmail.com", "Pablus_tester" + i);
//        appManager.getUserHelper().checkPolicy();
//        appManager.getUserHelper().submitForm();
//        Assert.assertTrue(appManager.getUserHelper().isRegistered());
//
//    }

    //******************************************* MODEL *****************************************
    @Test
    public void registrationTestModel() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Pablus").withLastName("Yatonu").withEmail("pablus" + i + "@gmail.com").withPassword("Pablus_tester" + i);
//        User user = new User()
//                .withName("Pablus").withLastName("Yatonu").withEmail("pablus@gmail.com").withPassword("Pablus_tester123");

        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user);
        appManager.getUserHelper().checkPolicy();
        appManager.getUserHelper().submitForm();
        Assert.assertTrue(appManager.getUserHelper().isRegistered());

    }
    //******************************************* MODEL *****************************************


    @Test
    public void regTestNegativeWrongField() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Pablus").withLastName("Yatonu").withEmail("pablus" + i + "@gmail.com").withPassword("ablus_tester" + i);

        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user);
        appManager.getUserHelper().checkPolicy();
//        appManager.getUserHelper().submitForm();
//        Assert.assertFalse(appManager.getUserHelper().isRegistered());
        Assert.assertFalse(appManager.getUserHelper().isValidField());
    }

    @Test
    public void regTestNegativeUserExist() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Pablus").withLastName("Yatonu").withEmail("pablus@gmail.com").withPassword("Pablus_tester123");
        logger.info("TestData: name: " + user.getName() + "; last name: " + user.getLastName() + "; email: " + user.getEmail() + "; password: " + user.getPassword());
        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user);
        appManager.getUserHelper().checkPolicy();
        appManager.getUserHelper().submitForm();
        Assert.assertFalse(appManager.getUserHelper().isRegistered());
    }

    @AfterMethod
    public void postCondition() {
        if (appManager.getUserHelper().isLogOutPresent()) {
            appManager.getUserHelper().logout();
        }
    }
}
