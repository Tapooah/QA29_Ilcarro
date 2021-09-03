package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }


    //***********************************************************************************


    //helpers
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    //helpers ^^^


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

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
}
