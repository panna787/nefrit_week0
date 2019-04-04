import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImdbFlow {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("imdb-signin-link")).click();

        driver.findElement(By.linkText("Sign in with IMDb")).click();

        driver.findElement(By.id("ap_email")).sendKeys("aniko.majoros87@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("imdbpassword");
        driver.findElement(By.id("signInSubmit")).click();

        driver.findElement(By.id("navbar-query")).sendKeys("shawshank");
        driver.findElement(By.id("navbar-submit-button")).click();

        driver.findElement(By.linkText("Watchlist")).click();
        driver.findElement(By.xpath("//*[@id=\"center-1-react\"]/div/div[1]/div/div[1]/a))")).click();

        driver.findElement(By.id("add-to-list-search")).sendKeys("shawshank");
    }
}
