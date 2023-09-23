package stepDefinitions;
import Methods.APIRequestMethods;
import Methods.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.io.IOException;


public class Step {
    
    String EndpointGet;
    Response ResponseGet;

    @Given("The Endpoint of the API Dummy")
    public void the_endpoint_of_the_api_get() throws IOException {
        EndpointGet = ConfigReader.URLGet();
    }

    @When("I send a request to the get users")
    public void user_send_a_request_to_the_api() throws IOException {
        ResponseGet = APIRequestMethods.sendGetRequestToAPI(EndpointGet);

    }

    @Then("The status code is equal To {int}")
    public void the_status_code_is_equal_to(Integer statusCode) {
        APIRequestMethods.verifyStatusCode(ResponseGet, statusCode);

    }

    @And("I verify the number of employees in the response is {int}")
    public void verify_number_of_employees_in_response(int expectedCount) {
        APIRequestMethods.verifyNumberOfEmployees(ResponseGet, expectedCount);
    }

}
