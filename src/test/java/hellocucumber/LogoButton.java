package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})

public class LogoButton {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();


    @Given("user accesses the home page")
    public void userAccessesTheHomePage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/index.html");

    }

    @When("user clicks on the contact button and back to the logo button")
    public void userClicksOnTheContactButtonAndBackToTheLogoButton() {
        WebElement contact = driver.findElement(By.xpath(("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")));
        contact.click();

    }

    @Then("user gets redirected to the contact page")
    public void userGetsRedirectedToTheHomePage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/contact.html");
    }


}