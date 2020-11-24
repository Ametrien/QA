package labnrsix;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignIn {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();

    @Given("user accesses the main page")
    public void userAccessesTheMainPage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/index.html");
    }

    @When("user fills in login and password")
    public void userFillsInLoginAndPassword() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[1]/a"));
        WebElement myEmail = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/form/div[1]/input"));
        WebElement myPassword = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/form/div[2]/input"));
        WebElement signInButton2 = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/form/input"));

        signInButton.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        myEmail.sendKeys("email");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        myPassword.sendKeys("test@test.com");
        signInButton2.click();

    }

    @Then("user logs in successfully")
    public void userLogsInSuccessfully() {
        if(driver.getCurrentUrl().startsWith("https://adoring-pasteur-3ae17d.netlify.app/index.html#")){
            Assert.fail();
            System.out.println( "Could not log in");
        }
    }
}
