package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {


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

        appManager.getSearchHelper().clickOnSearchTab();
        appManager.getSearchHelper().fillFormForSearching();
        Assert.assertTrue(appManager.getSearchHelper().isFilledSearchFine());
        //out of HW
//        appManager.getUserHelper().chooseAndRentCar();

    }

    @Test
    public void searchTestByTypeNegative() {


    }

    @Test
    public void searchDateBySelectCurrentMonth() {
        appManager.getSearchHelper().fillSearchForm("Rehovot", "10/25/2021", "12/30/2021");
        appManager.getUserHelper().submitForm();
        Assert.assertTrue(appManager.getSearchHelper().isListOfCarsAppeared());
    }

    @Test
    public void searchDateByArrows(){

        appManager.getSearchHelper().selectDateInFuture("Rehovot", "11/25/2021", "4/30/2022");
        appManager.getUserHelper().submitForm();
        Assert.assertTrue(appManager.getSearchHelper().isListOfCarsAppeared());
    }




//    @AfterMethod
//    public void postCondition() {
//
//    }
}
