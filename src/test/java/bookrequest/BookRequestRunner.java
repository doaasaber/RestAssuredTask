package bookrequest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/bookrequest/bookrequest.feature"},
        glue = {"commonsteps", "bookrequest"},
        plugin = {"pretty","html:target/cucumber-reports"}
)
public class BookRequestRunner extends AbstractTestNGCucumberTests {
}
