package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    HelperCar car;
    SearchHelper search;

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        car = new HelperCar(wd);
        search = new SearchHelper(wd);
    }

    public void stop() {
//        wd.quit();
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HelperCar getCar() {
        return car;
    }

    public SearchHelper getSearchHelper() {
        return search;
    }
}
