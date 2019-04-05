import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User {

    public static void signIn(WebDriver driver){
        driver.findElement(By.id("imdb-signin-link")).click();
        driver.findElement(By.linkText("Sign in with IMDb")).click();
        driver.findElement(By.id("ap_email")).sendKeys("aniko.majoros87@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("imdbpassword");
        driver.findElement(By.id("signInSubmit")).click();
    }

    public static void logOut(WebDriver driver, Actions action){
        action.moveToElement(driver.findElement(By.id("navUserMenu"))).build().perform();
        App.waitForElementToBeVisible(driver, driver.findElement(By.id("nblogout")));
        driver.findElement(By.id("nblogout")).click();
    }
}
