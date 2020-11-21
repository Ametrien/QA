package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactForm {

    static {
        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");
    }

    WebDriver driver = new ChromeDriver();


    @Given("user accesses the contact page")
    public void userAccessesTheContactPage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/contact.html");
    }

    @When("user fills in the data")
    public void userFillsInTheData() {
        WebElement name = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[1]/input"));
        WebElement email = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[2]/input"));
        WebElement subject = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[3]/input"));
        WebElement message = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[4]/textarea"));
        WebElement send = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/input"));
        name.sendKeys("Name");
        email.sendKeys("anastasia.ivanova@ati.utm.md");
        subject.sendKeys("My message");
        message.sendKeys("Here it is");
        send.click();
    }

    @Then("user's e-mail is sent")
    public void usersEMailIsSent() {
        if(driver.getCurrentUrl().startsWith("https://adoring-pasteur-3ae17d.netlify.app/contact.html#")){
        Assert.fail();
        System.out.println( "E-mail was not sent");
        }
    }
}
