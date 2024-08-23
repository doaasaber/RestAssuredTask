package bookrequest;

import commonsteps.Commonsteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BookRequestSteps {
    private Response response;
    JSONObject request = new JSONObject();
    String firstname;
    String lastname;
    String totalPrice;
    String depositPaid;
    String checkIn;
    String checkOut;
    String additionalNeeds;
    String SheetName="Booking";
    @When("user put valid data based on sentence from row: \"([^\"]*)\"$")
    public void userPutValidData(int row){
         firstname=Commonsteps.excelReadFile.getCellData(SheetName,row,"firstname");
         lastname=Commonsteps.excelReadFile.getCellData(SheetName,row,"lastname");
         totalPrice=Commonsteps.excelReadFile.getCellData(SheetName,row,"totalprice");
         depositPaid=Commonsteps.excelReadFile.getCellData(SheetName,row,"depositpaid");
         checkIn=Commonsteps.excelReadFile.getCellData(SheetName,row,"checkin");
        System.out.println(checkIn);
        checkOut=Commonsteps.excelReadFile.getCellData(SheetName,row,"checkout");
        System.out.println(checkOut);
        additionalNeeds=Commonsteps.excelReadFile.getCellData(SheetName,row,"additionalneeds");
        request.put("firstname", firstname);
        request.put("lastname", lastname);
        request.put("totalprice", totalPrice);
        request.put("depositpaid", depositPaid);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkIn);
        bookingDates.put("checkout", checkOut);
        request.put("bookingdates", bookingDates);
        request.put("additionalneeds", additionalNeeds);

    }
    @And("user send a POST request to : \"([^\"]*)\"$")
    public void userSendAGetRequest(String endpoint) {
        response = given().header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post(endpoint);
    }



    @Then("validate on response status code  : \"([^\"]*)\"$")
    public void validateOnResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("validate on response")
    public void validateOnResponse() {
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        assertThat(responseBody.contains(firstname), equalTo(true));
        assertThat(responseBody.contains(lastname), equalTo(true));
        assertThat(responseBody.contains(totalPrice), equalTo(true));
        assertThat(responseBody.contains(depositPaid), equalTo(true));
        //assertThat(responseBody.contains(checkIn), equalTo(true));
        //assertThat(responseBody.contains(checkOut), equalTo(true));
        assertThat(responseBody.contains(additionalNeeds), equalTo(true));

    }
}
