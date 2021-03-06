import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

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
        User.logout(driver, actions);
    }

    @Test
    public void signIn_WithValidEmailAndInvalidPassword(){
        User.signIn(driver, "aniko.majoros87@gmail.com", "something");
        assertEquals("Your password is incorrect", driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void signIn_WithInvalidEmailAndValidPassword(){
        User.signIn(driver, "something_notemail", "imdbpassword");
        assertEquals("We cannot find an account with that email address", driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void signIn_WithEmptyInputFields(){
        WebElement signInButton = driver.findElement(By.id("imdb-signin-link"));
        App.waitForElementToBeClickable(driver, signInButton);
        User.signIn(driver, "", "");
        List<String> messages = driver.findElements(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/dl"))
                .stream().map(e -> e.getText()).collect(Collectors.toList());
        System.out.println(messages.get(0));
        assertEquals("Enter your email\n" +  "Enter your password", messages.get(0));


    }

    @AfterClass
    public static void closeSession(){
        driver.quit();
    }

}
