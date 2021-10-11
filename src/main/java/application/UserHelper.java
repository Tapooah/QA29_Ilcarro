package application;

import models.User;
import org.openqa.selenium.*;


public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String pass) {
        type(By.id("email"), email);
        type(By.id("password"), pass);
    }

    public void fillLoginForm(User user) {

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void submitForm() {
//        click(By.cssSelector("button[type='submit']"));
        click(By.xpath("//button[@type='submit']"));
    }

    //  //h2[text()='Logged in success']
    public boolean isLogged() {
        String res = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        click(By.xpath("//button[text()='Ok']"));
        return res.equals("Logged in success");
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastname, String mail, String pass) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastname);
        type(By.id("email"), mail);
//        click(By.xpath("//input[@id='email']"));
        type(By.id("password"), pass);
        click(By.xpath("//input[@id='email']"));
    }


    //-----------------reload method--------------------------

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        click(By.xpath("//input[@id='email']"));
    }

    //-----------------------------------------------------------


    public void checkPolicy() {
//        click(By.xpath("//label[@for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }

    public boolean isRegistered() {
        String res = wd.findElement(By.cssSelector(".dialog-container h1")).getText();
        click(By.xpath("//button[text()='Ok']"));
        return res.equals("Registered");
    }


    public boolean isValidField() {
//        click(By.xpath("//button[text()='Ok']"));
        return isElementPresent(By.xpath("//input[@className='ng-touched ng-dirty ng-invalid']"));
    }

    public void pause(int millies) {

        try {
            Thread.sleep(millies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------HW-for-12.10.21--------------------------------------------------
    public void clickOnSearchTab() {
        click(By.xpath("//a[text()=' Search ']"));
    }

    public void fillFormForSearching() {
        WebElement chooseCity = wd.findElement(By.id("city"));
//choose and fill field "city"
        chooseCity.sendKeys("T");
        pause(1000);
        chooseCity.sendKeys(Keys.ARROW_DOWN);
        chooseCity.sendKeys(Keys.ENTER);
//chooose and fill field "Dates"
        WebElement chooseDates = wd.findElement(By.id("dates"));
        chooseDates.click();
        //select month
//        click(By.xpath("//button[@aria-label='Next month']"));
        //select year, month, and days with button
        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath("//div[normalize-space()='2022']"));
        click(By.xpath("//div[normalize-space()='AUG']"));
        click(By.xpath("//div[normalize-space()='16']"));
        click(By.xpath("//div[normalize-space()='23']"));
        click(By.cssSelector(".search-container"));
//        click(By.cssSelector("button[type='submit']"));
    }

    public boolean isFilledSearchFine() {
        pause(2000);
        return isElementPresent(By.cssSelector("button[type='submit']"));
    }
    //-------------------------------------^^HW-for-12.10.21^^------------------------------------------------


    public void scroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void chooseAndRentCar() {
        pause(1000);
        scroll(0, 550);
        pause(2000);
//        click(By.xpath("//span[@class='title'])[5]"));
        click(By.cssSelector("a[@style='background-image: url(\"https://i.imgur.com/waQAIUz.jpg"));
//        click(By.xpath("//button[normalize-space()='Rent now!!']"));
//        type(By.id("phone"), "0123456789");
//        click(By.id("mat-dialog-0"));
//        click(By.cssSelector("button[type='submit']"));
    }
}
