import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Movies {

    public static void search(WebDriver driver){
        WebElement searchField = driver.findElement(By.id("navbar-query"));
        App.waitForElementToBeVisible(driver, searchField);
        searchField.sendKeys("shawshank");
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a"));
        App.waitForElementToBeVisible(driver, firstResult).click();
    }

    public static void addSearchResultToWatchlist(WebDriver driver){
        WebElement watchlistButton = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/span/div"));
        search(driver);
        App.waitForElementToBeVisible(driver, watchlistButton).click();

    }

    public static void rateSearchResult(WebDriver driver, Actions actions){
        search(driver);
        WebElement ratingWidget = driver.findElement(By.id("star-rating-widget"));
        actions.moveToElement(ratingWidget).build().perform();
        ratingWidget.click();
        //TODO finish this!
    }

    public static void getWatchlist(WebDriver driver){
        driver.findElement(By.linkText("Watchlist")).click();
    }

    public static void editWatchlist(WebDriver driver){
        driver.findElement(By.linkText("EDIT")).click();
    }

    public static void orderWatchlist(WebDriver driver){
        getWatchlist(driver);
        Select dropDown = new Select(driver.findElement(By.id("lister-sort-by-options")));
        dropDown.selectByValue("ALPHA");
    }
}
