package generatetokenrequest;
import commonsteps.Commonsteps;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class GenerateTokenRequestSteps {
    private Response response;
    JSONObject request = new JSONObject();
    SoftAssert softAssert = new SoftAssert();

    @When("user put valid data based on sentence from row: \"([^\"]*)\"$")
    public void userSentToPoetRequestWithValidData(int row) {
        String userName=Commonsteps.excelReadFile.getCellData("GenerateToken",row,"username");
        String password=Commonsteps.excelReadFile.getCellData("GenerateToken",row,"password");
        request.put("username", userName);
        request.put("password", password);


    }
    @And("user send to post endpoint : \"([^\"]*)\"$")
    public void userSendToPostEndpoint(String endpoint){
        response = given().header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post(endpoint); }



    @Then("validate on response status code  : \"([^\"]*)\"$")
    public void validateOnResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("validate on response:\"([^\"]*)\"$")
    public void validateOnResponse(String key) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody.contains(key), equalTo(true));
        String token = response.jsonPath().getString(key);
        softAssert.assertFalse(token.isEmpty());
        softAssert.assertAll();
    }


}
