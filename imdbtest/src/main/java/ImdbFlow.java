import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImdbFlow {

    public static void main(String[] args) throws Exception{

        WebDriver driver = new FirefoxDriver();

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar-query")));
        driver.findElement(By.id("navbar-query")).sendKeys("shawshank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"navbar-suggestionsearch\"]/div[1]/a")).click();
        //add search result to watchlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/span/div")));
        driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/span/div")).click();

        //navigate to watchlist
        driver.findElement(By.linkText("Watchlist")).click();
        driver.findElement(By.linkText("EDIT")).click();
        //remove element from watchlist
        driver.findElement(By.id("1489762812")).click();
        driver.findElement(By.id("delete_items")).click();
        driver.findElement(By.xpath("//*[@id=\"delete_items_form\"]/div/input")).click();
        //add element to watchlist with search
        driver.findElement(By.id("add-to-list-search")).sendKeys("submarine");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]")));
        driver.findElement(By.xpath("//*[@id=\"add-to-list-search-results\"]/a[1]")).click();

        //sort watchlist
        driver.findElement(By.linkText("Watchlist")).click();
        Select dropDown = new Select(driver.findElement(By.id("lister-sort-by-options")));
        dropDown.selectByValue("ALPHA");*/

        //Activities
        Actions action = new Actions(driver);
        /*action.moveToElement(driver.findElement(By.id("nbusername"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navUserMenu\"]/div/div[2]/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"navUserMenu\"]/div/div[2]/ul/li[1]/a")).click();
*/
        //Ratings
        action.moveToElement(driver.findElement(By.id("home_img"))).build().perform();
        action.moveToElement(driver.findElement(By.id("nbusername"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navUserMenu\"]/div/div[2]/ul/li[3]/a")));
        driver.findElement(By.xpath("//*[@id=\"navUserMenu\"]/div/div[2]/ul/li[3]/a")).click();


        //close browser
        Thread.sleep(3000);
        driver.quit();
    }
}
