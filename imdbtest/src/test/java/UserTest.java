import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
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
    public void getMainPage(){
        App.getMainPage(driver);
    }

    @Test
    public void signIn_WithValidEmailAndPassword(){
        User.signIn(driver, "aniko.majoros87@gmail.com", "imdbpassword");
        assertEquals("panna787", driver.findElement(By.id("nbusername")).getText());
    }

    @AfterClass
    public static void closeSession(){
        driver.quit();
    }

}
