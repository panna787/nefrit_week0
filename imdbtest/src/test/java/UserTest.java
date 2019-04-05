import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UserTest {

    static WebDriver driver = new FirefoxDriver();
    static Actions actions = new Actions(driver);

    @BeforeClass
    public static void startSession(){
        App.startSession(driver);
    }

    @Before
    public static void getMainPage(){
        App.getMainPage(driver);
    }

    @AfterClass
    public static void closeSession(){
        driver.quit();
    }

}
