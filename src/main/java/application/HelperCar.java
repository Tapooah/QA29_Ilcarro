package application;

import models.Car;
import models.CarLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void initAddingnewCar() {
        click(By.xpath("//a[@href='/let-car-work']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());

        selectFuel(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getwD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.cssSelector(".feature-input"), car.getTypeFeature());
        type(By.id("about"), car.getAbout());

    }

    public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    private void selectFuel(By locator, String option) {
//        new Select(wd.findElement(locator)).selectByIndex(1);
//        new Select(wd.findElement(locator)).selectByValue("Electric");
//        new Select(wd.findElement(locator)).selectByVisibleText(" Electric ");

        Select select = new Select(wd.findElement(locator));

        if (option.equals("Electric")) {
            //new Select(wd.findElement(locator)).selectByIndex(1);
            select.selectByValue("Electric");
        } else if (option.equals("Petrol")) {
            select.selectByValue("Petrol");
        }
    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        pause(500);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }


    public void attachPhoto() {
        wd.findElement(By.id("photos")).sendKeys("D:\\GitHub\\QA29_Ilcarro\\img\\mini-cooper-se-2019-768x432.jpg");
    }

    public void clickButtonSubmit() {
//        pause(1000);
        new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[.='Submit']"))));
        click(By.xpath("//button[.='Submit']"));
    }


    public boolean isCarAdded() {
        String res = wd.findElement(By.cssSelector("div[class='dialog-container'] h1[class='title']")).getText();
        pause(2000);
        click(By.cssSelector("button[class='positive-button ng-star-inserted']"));
        return res.equals("Car added");
    }
}
