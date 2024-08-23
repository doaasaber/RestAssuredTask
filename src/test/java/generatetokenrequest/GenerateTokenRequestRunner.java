package generatetokenrequest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/generatetokenrequest/generatetokenrequest.feature"},
        glue = {"commonsteps", "generatetokenrequest"},
        plugin = {"pretty","html:target/cucumber-reports"}
)
public class GenerateTokenRequestRunner extends AbstractTestNGCucumberTests {
}
