package labnrseven;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LabSeven {

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();

    @Given("Chrome browser is open")
    public void chromeBrowserIsOpen() {
    if(driver != null){
        System.out.println("The browser is open");
        }
    }


    @When("user goes to Google.co.in")
    public void userGoesToGoogleCoIn() {
        driver.get("https://www.google.co.in\n");

    }

    @Then("the webpage is loaded")
    public void theWebpageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement elem = driver.findElement(By.id("hplogo"));
        elem.click();
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    @When("user searches for something")
    public void userSearchesForTest() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("test");
        search.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("user can see how many results are displayed")
    public void userCanSeeHowManyResultsAreDisplayed() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println(("The number of results is " + rows.size()));
    }

    @When("user does not enter anything and clicks on search")
    public void userDoesNotEnterAnythingAndClicksOnSearch() {
        driver.get("https://www.google.co.in");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("");
        search.sendKeys(Keys.ENTER);

    }

    @Then("nothing should occur")
    public void nothingShouldOccur() {

        if(driver.getCurrentUrl().startsWith("https://www.google.co.in"))
            System.out.println("Success, nothing changed");
        else
            System.out.println("Oops, something changed");
    }

    @When("user searched for something irrelevant \\(misspelled)")
    public void userSearchedForSomethingIrrelevantMisspelled() {
        driver.get("https://www.google.co.in");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("mispeled");
        search.sendKeys(Keys.ENTER);

    }

    @Then("there is a \"Did you mean” link")
    public void thereIsADidYouMeanLink() {
        WebElement mp = driver.findElement(By.className("gL9Hy"));
        if (mp != null){
            System.out.println("There is a \"Did you mean something else\" section");
        } else
            System.out.println("Oops, there is no \"Did you mean something else\" section");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @After
    public void quitDriver(){
//        driver.close();
        driver.quit();
    }


}
