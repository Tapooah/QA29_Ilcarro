package application;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Arrays;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectDate(dateFrom, dateTo);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
//        pause(2000);
    }

    public void selectDate(String dateFrom, String dateTo) {
        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");
        click(By.id("dates"));

        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);
        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));
    }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
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


    //---------------------------------------HW-for-15.10.21--------------------------------------------------
/*
//    public void selectDateInFuture(String city, String dateTo) {
//        //input city
//        fillInputCity(city);
//        //about dates
//        int currentMonth = LocalDate.now().getMonthValue();
//        int currentDay = LocalDate.now().getDayOfMonth();
//        int currentYear = LocalDate.now().getYear();
//        int[] arrayDate = {currentMonth, currentDay, currentYear};
//
//        String[] dateT = dateTo.split("/");
//        click(By.id("dates"));
//        ///dateFrom
//        String locatorFrom = String.format("//div[text()=' %s ']", currentDay);
//        click(By.xpath(locatorFrom));
//
////        dateTo
//        int fMonth = Integer.parseInt(dateT[0]);
//        int allMonth = 12 - currentMonth;
//        int countClick = 0;
//
//        if ((fMonth <= currentMonth)) {
//            countClick = allMonth + fMonth;
//        }
//
//        for (int i = 1; i <= countClick; i++) {
//            click(By.xpath("//button[@aria-label='Next month']"));
//        }
////        pause(1000);
//        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);
//
//        click(By.xpath(locatorTo));
//}
*/

    public void selectDateInFuture(String city, String dateFrom, String dateTo) {
        //input city
        fillInputCity(city);

        //about dates
        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");
        click(By.id("dates"));

        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        click(By.xpath(locatorFrom));

        int currentMonth = LocalDate.now().getMonthValue();
        int fMonth = Integer.parseInt(dateT[0]);
        int countClick = fMonth - currentMonth;
        for (int i = 1; i <= countClick; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }

        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);
        click(By.xpath(locatorTo));
    }
    //-------------------------------------^^HW-for-15.10.21^^------------------------------------------------

}
