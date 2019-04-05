import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User {

    public static void signIn(WebDriver driver, String email, String password){
        driver.findElement(By.id("imdb-signin-link")).click();
        driver.findElement(By.linkText("Sign in with IMDb")).click();
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }

    public static void navigateToActivity(WebDriver driver, Actions actions){
        WebElement userMenu = driver.findElement(By.id("navUserMenu"));
        actions.moveToElement(userMenu).build().perform();
        WebElement activityLink = driver.findElement(By.xpath("//*[@id=\"navUserMenu\"]/div/div[2]/ul/li[1]/a"));
        App.waitForElementToBeVisible(driver, activityLink);
        App.waitForElementToBeClickable(driver, activityLink).click();
    }

    public static void logout(WebDriver driver, Actions action){
        WebElement userMenu = driver.findElement(By.id("navUserMenu"));
        action.moveToElement(userMenu).build().perform();
        WebElement logout = driver.findElement(By.id("nblogout"));
        App.waitForElementToBeVisible(driver, logout);
        App.waitForElementToBeClickable(driver, logout).click();
    }
}
