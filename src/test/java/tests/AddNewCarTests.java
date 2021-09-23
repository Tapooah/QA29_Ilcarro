package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //login
        User user = new User().withEmail("pablus@gmail.com").withPassword("Pablus_tester123");

        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm(user);
        appManager.getUserHelper().submitForm();

    }

    @Test
    public void addNewCarSuccess() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = new Car()
                .withAddress("Tel Aviv, Israel")
                .withMake("BMW")
                .withModel("Cooper SE")
                .withYear("2019")
                .withEngine("Electric")
                .withFuel("Electric")
                .withGear("AT")
                .withwD("AWD")
                .withDoors("3")
                .withSeats("2")
                .withCarClass("A")
                .withFuelConsumption("6.5")
                .withCarRegNumber("100-66-" + i)
                .withPrice("65")
                .withDistanceIncluded("500")
                .withTypeFeature("type of")
                .withAbout(" Very good car");


        appManager.getCar().initAddingnewCar();
        appManager.getCar().fillCarForm(car);
        appManager.getCar().attachPhoto();
        appManager.getCar().clickButtonSubmit();

        Assert.assertTrue(appManager.getCar().isCarAdded());

    }

    @AfterMethod
    public void postCondition() {
        if (appManager.getUserHelper().isLogOutPresent()) {
            appManager.getUserHelper().logout();
        }

    }

}
