package Methods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class APIRequestMethods {
    private static String apiKey = "61f4248c9d9bb038eaf0c6c0";

    public static Response sendGetRequestToAPI(String endpoint) throws IOException {
        return  given()
                .header("app-id", apiKey)
                .header("Accept-Language", "fr-FR")
                .header("Content-Type", "application/json")
                .get(endpoint);
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        response.then().log().all().statusCode(expectedStatusCode);
    }

    public static void verifyNumberOfEmployees(Response response, int expectedCount) {
        JsonPath jsonPath = response.jsonPath();
        int actualCount = jsonPath.getList("data").size();
        
        Assert.assertEquals(actualCount, expectedCount, "Number of employees does not match the expected count.");
    }



}
