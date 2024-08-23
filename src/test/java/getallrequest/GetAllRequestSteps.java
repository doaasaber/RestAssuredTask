package getallrequest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllRequestSteps  {

    private Response response;

    @When("user send a GET request to : \"([^\"]*)\"$")
    public void userSendAGetRequest(String endpoint) {
        response = given().when().get(endpoint);
    }

    @Then("validate on response status code  : \"([^\"]*)\"$")
    public void validateOnResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("validate on response")
    public void validateOnResponse() {
        List<?> booking = response.jsonPath().getList("$");
        assertThat("booking size greater than 0",booking.size()>0);


    }
}
