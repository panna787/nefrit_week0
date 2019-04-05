import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Movies {

    public static void search(WebDriver driver){
        WebElement searchField = driver.findElement(By.id("navbar-query"));
        App.waitForElementToBeVisible(driver, searchField);
        searchField.sendKeys("shawshank");
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a"));
        App.waitForElementToBeVisible(driver, firstResult).click();
    }

    public static void addSearchedMovieToWatchlist(WebDriver driver){
        WebElement watchlistButton = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/span/div"));
        search(driver);
        App.waitForElementToBeVisible(driver, watchlistButton).click();

    }

    public static void getWatchlist(WebDriver driver){
        driver.findElement(By.linkText("Watchlist")).click();
    }

    public static void editWatchlist(WebDriver driver){
        driver.findElement(By.linkText("EDIT")).click();
    }
}
