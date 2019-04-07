import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    static WebDriverWait wait;

    public static void startSession(WebDriver driver){
        driver.manage().window().maximize();
    }

    public static void getMainPage(WebDriver driver){
        driver.manage().deleteAllCookies();
        driver.get("https://www.imdb.com/");
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void closeBrowser(WebDriver driver){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
