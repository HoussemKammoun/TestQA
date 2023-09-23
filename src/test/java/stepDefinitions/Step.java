package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertTrue;
import Methods.APIRequestMethods;
import Methods.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

public class Step {
    
    String EndpointGet;
    Response ResponseGet;

    @Given("The Endpoint of the API Get")
    public void the_endpoint_of_the_api_get() throws IOException {
        EndpointGet = //"https://dummyapi.io/data/v1/use";
        		//"https://testqa.purse.tech/fake-contact";
        		//"https://testqa.purse.tech/favicon.ico";
        		ConfigReader.URLGet();
    }

    @When("user send a request to the API")
    public void user_send_a_request_to_the_api() throws IOException {
        ResponseGet = APIRequestMethods.sendGetRequestToAPI(EndpointGet);

    }

    @Then("The status code is equal To {int}")
    public void the_status_code_is_equal_to(Integer statusCode) {
        APIRequestMethods.verifyStatusCode(ResponseGet, statusCode);

    }

}
