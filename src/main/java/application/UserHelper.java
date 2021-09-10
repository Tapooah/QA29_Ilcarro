package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
        type(By.id("password"), pass);
    }

    public void checkPolicy() {
//        click(By.xpath("//label[@for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");


    }
}
