/*
Serializing a Java object to a JSON Request Body
 */

package in.reqres;

import in.reqres.model.UserRequest;
import in.reqres.utils.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUserTest {

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String BASE_PATH = "api/users";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestResponseSpecification() {
        requestSpec = new RequestSpecBuilder().setBaseUri(BASE_URL).setBasePath(BASE_PATH).setContentType(ContentType.JSON).build();
        responseSpec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void createUser_checkStatusCode_checkResponseBody() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("morpheus");
        userRequest.setJob("leader");

        String id = given()
                .body(userRequest)
                .spec(requestSpec)
                .when()
                .post()
                .then()
                .log().body()
                .spec(responseSpec)
                .extract()
                .path("id");

        Assert.assertNotNull(id);
    }
}
