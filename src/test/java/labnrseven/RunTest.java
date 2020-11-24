package labnrseven;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/labnrseven",
        plugin = { "pretty" },
        monochrome = true
)
public class RunTest {
}
