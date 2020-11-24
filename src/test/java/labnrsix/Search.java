package labnrsix;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();


    @Given("user accesses the index page")
    public void userAccessesTheIndexPage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/index.html");
    }

    @When("user searches for a blazer")
    public void userSearchesForABlazer() {
        WebElement search = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form/input[1]"));
        search.sendKeys("blazer");
        search.sendKeys(Keys.ENTER);
    }

    @Then("user gets redirected to blazer")
    public void userGetsRedirectedToBlazer() {
        if(driver.getCurrentUrl().startsWith("https://adoring-pasteur-3ae17d.netlify.app/mens.html"))
            System.out.println("Success");
        else
            System.out.println("Failure");
        Assert.fail();
    }
}
