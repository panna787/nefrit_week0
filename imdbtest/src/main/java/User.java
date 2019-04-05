import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User {

    public static void signIn(WebDriver driver){
        driver.findElement(By.id("imdb-signin-link")).click();
        driver.findElement(By.linkText("Sign in with IMDb")).click();
        driver.findElement(By.id("ap_email")).sendKeys("aniko.majoros87@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("imdbpassword");
        driver.findElement(By.id("signInSubmit")).click();
    }
}
