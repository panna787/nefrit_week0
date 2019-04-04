import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImdbFlow {

    public static void main(String[] args) throws Exception{

        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        //get main page
        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();

        //sign in
        driver.findElement(By.id("imdb-signin-link")).click();
        driver.findElement(By.linkText("Sign in with IMDb")).click();
        driver.findElement(By.id("ap_email")).sendKeys("aniko.majoros87@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("imdbpassword");
        driver.findElement(By.id("signInSubmit")).click();

        //search
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.id("navbar-query")).sendKeys("shawshank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a")).click();

        //navigate to watchlist
        driver.findElement(By.linkText("Watchlist")).click();
        driver.findElement(By.linkText("EDIT")).click();
        //add element to watchlist with search
        driver.findElement(By.id("add-to-list-search")).sendKeys("shawshank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]")));
        driver.findElement(By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]")).click();

        //close
        Thread.sleep(3000);
        driver.close();
    }
}
