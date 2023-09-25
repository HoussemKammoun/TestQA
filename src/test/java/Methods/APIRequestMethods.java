package Methods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import org.testng.Assert;

public class APIRequestMethods {

    // Method to send a get request to the API
    public static Response sendGetRequestToAPI(String endpoint) throws IOException {
        return given()
                .header("app-id", ConfigReader.GetApiKey())
                .header("Content-Type", "application/json")
                .header("Accept-Language", "fr-FR")
                .get(ConfigReader.URLGet());
    }

    // Method to check the response status code
    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        response.then().log().all().statusCode(expectedStatusCode);
    }

    // Method to check data are in right format
    public static void verifyUsersFormat(Response response) {
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, String>> users = jsonPath.getList("data");
    
        for (Map<String, String> user : users) {
            String id = user.get("id");
            String title = user.get("title");
            String firstName = user.get("firstName");
            String lastName = user.get("lastName");
            String picture = user.get("picture");
    
            Assert.assertTrue(id.matches("^[0-9a-z]+$"), "id is not in the right format");
            Assert.assertTrue(title.equals("mr") || title.equals("ms") || title.equals("mrs") || title.equals("miss"), "Title is not 'mr' or 'mrs': " + title);
            Assert.assertTrue(firstName.matches("^[a-zA-Z-]+$"), "firstName is not in the right format"); // Check firstName
            Assert.assertTrue(lastName.matches("^[a-zA-Z]+$"), "lastName is not in the right format");
            Assert.assertTrue(picture.startsWith("https"), "picture is not in the right format");
        }
    }
    


}
