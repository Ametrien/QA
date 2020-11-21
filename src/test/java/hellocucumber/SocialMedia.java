package hellocucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SocialMedia {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();


    @Given("user accesses the about page")
    public void userAccessesTheAboutPage() {

        driver.get("https://adoring-pasteur-3ae17d.netlify.app/about.html");

    }

    @When("user clicks on a social media button")
    public void userClicksOnASocialMediaButton() {
        WebElement instagram = driver.findElement(By.xpath("/html/body/div[14]/div/div[1]/ul/li[3]"));
        instagram.click();
    }

    @Then("user gets redirected to social media profile")
    public void userGetsRedirectedToSocialMediaProfile() {
        if(driver.getCurrentUrl().startsWith("https://www.instagram.com"))
            System.out.println("Success");
        else
            System.out.println("Failure");
            Assert.fail();
    }
}
