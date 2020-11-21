package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartActivity {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();


    @Given("user accesses the shop")
    public void userAccessesTheShop() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/mens.html\n");
    }

    @When("user user clicks on a product to add it to cart")
    public void userUserClicksOnAProductToAddItToCart() {
        WebElement blazer = driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div[1]/div/div[2]/div[2]/form/fieldset/input[10]"));
        blazer.click();

    }

    @Then("it is shown in the cart")
    public void itIsShownInTheCart() {
        WebElement miniCart = driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li[1]"));
        if (miniCart != null){
            System.out.println("Element exists");
        } else
            Assert.fail();
    }
}
