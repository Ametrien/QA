import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class LabFive {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/stacey/Downloads/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.aliexpress.com/");

        WebElement search = driver.findElement(By.id("search-key"));
        WebElement header =  driver.findElement(By.className("top-lighthouse"));
        boolean check = header.isDisplayed();
        search.sendKeys("computer");
        search.sendKeys(Keys.ENTER);

        if(check){
            System.out.println("Header is visible");
        } else{
            System.out.println("Header is not visible");
        }
    }
}

