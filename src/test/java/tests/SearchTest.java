package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    //-------------------по условиям ДЗ preconditions не требуется.-------------------

//    @BeforeMethod
//    public void preconditions() {
//        User user = new User().withEmail("pablus@gmail.com").withPassword("Pablus_tester123");
//
//        appManager.getUserHelper().openLoginForm();
//        appManager.getUserHelper().fillLoginForm(user);
//        appManager.getUserHelper().submitForm();
//        appManager.getUserHelper().isLogged();
//    }

    @Test
    public void newSearchTest() {

        appManager.getUserHelper().clickOnSearchTab();
        appManager.getUserHelper().fillFormForSearching();

        Assert.assertTrue(appManager.getUserHelper().isFilledSearchFine());
        //out of HW
//        appManager.getUserHelper().chooseAndRentCar();

    }
//    @AfterMethod
//    public void postCondition() {
//
//    }
}
