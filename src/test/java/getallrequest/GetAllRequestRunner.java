package getallrequest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/getallrequest/getallrequest.feature"},
        glue = {"commonsteps","getallrequest"},
        plugin = {"pretty","html:target/cucumber-reports"}
)
public class GetAllRequestRunner extends AbstractTestNGCucumberTests {
}
