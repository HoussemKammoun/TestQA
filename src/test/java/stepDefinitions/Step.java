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

    // set the API endpoint
    @Given("The Endpoint of the API Dummy")
    public void the_endpoint_of_the_api_get() throws IOException {
        EndpointGet = ConfigReader.URLGet();
    }

    // send a GET request to the API
    @When("I send a request to the get users")
    public void user_send_a_request_to_the_api() throws IOException {
        ResponseGet = APIRequestMethods.sendGetRequestToAPI(EndpointGet);

    }

    // verify the response status code
    @Then("The status code is equal To {int}")
    public void the_status_code_is_equal_to(Integer statusCode) {
        APIRequestMethods.verifyStatusCode(ResponseGet, statusCode);

    }

    // verify the number of employees in the response
    @And("the number of employees in the response is {int}")
    public void verify_number_of_employees_in_response(int expectedCount) {
        APIRequestMethods.verifyNumberOfEmployees(ResponseGet, expectedCount);
    }
    
    // verify the format of the first employee name in the response
    @Then("the employeeName and the employeeSalary have the good format")
    public void verify_first_employee_name_matches_pattern() {
        APIRequestMethods.verifyFormatElements(ResponseGet);
    }

}
