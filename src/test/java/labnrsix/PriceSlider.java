package labnrsix;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PriceSlider {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();

    @Given("user accesses the price page")
    public void userAccessesThePricePage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/womens2.html");

    }

    @When("user interacts with slider")
    public void userInteractsWithSlider() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/div"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 90, 0);
        move.build().perform();

    }

    @Then("the price range changes")
    public void thePriceRangeChanges() {
        WebElement changes = driver.findElement(By.cssSelector("left: 59.1333%;"));
        if(changes != null){
            System.out.println("It worked!");
        } else
            Assert.fail();
    }
}
