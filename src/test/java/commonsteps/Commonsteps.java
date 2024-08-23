package commonsteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import utilities.ExcelReadFile;

public class Commonsteps {
    public static ExcelReadFile excelReadFile;
    public static Scenario scenario;

    @Before
    public void browserInitialization(Scenario scenario) throws Exception {
        excelReadFile = new ExcelReadFile("input.xlsx");

    }
    @Given("the base URL is set")
    public void initiateTest(){
        BaseUrl.propInitiate();
        RestAssured.baseURI=BaseUrl.props.getProperty("Url.Base");

    }



}
