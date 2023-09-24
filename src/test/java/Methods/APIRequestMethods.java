package Methods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class APIRequestMethods {

    // Method to send a get request to the API
    public static Response sendGetRequestToAPI(String endpoint) throws IOException {
        return given()
                .header("app-id", ConfigReader.GetApiKey())
                .header("Accept-Language", "fr-FR")
                .header("Content-Type", "application/json")
                .get(endpoint);
    }

    // Method to check the response status code
    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        response.then().log().all().statusCode(expectedStatusCode);
    }

    // Method to check the number of employees in the response
    public static void verifyNumberOfEmployees(Response response, int expectedCount) {
        JsonPath jsonPath = response.jsonPath();
        int actualCount = jsonPath.getList("data").size();  
        Assert.assertEquals(actualCount, expectedCount, "Number of employees does not match the expected count.");
    }

    // Method to check the format of elements in the response
    public static void verifyFormatElements(Response response) {
        JsonPath jsonResponseJsonPath = response.jsonPath();
        String firstName = jsonResponseJsonPath.getString("data[0].employee_name");
        String employeeSalary = jsonResponseJsonPath.getString("data[0].employee_salary");
        
        // verify that the employee name contains only alphabetic characters
        Assert.assertTrue(firstName.matches("^[A-Za-z -]+$"), "Employee Name contains invalid characters.");
        
        // verify that the employee salary contains only numeric characters
        Assert.assertTrue(employeeSalary.matches("^[0-9]+$"), "Employee Salary contains non-numeric characters.");
    }
}
