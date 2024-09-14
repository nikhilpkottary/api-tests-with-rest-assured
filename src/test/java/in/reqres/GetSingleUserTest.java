package in.reqres;

import in.reqres.utils.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserTest {
    private static final String BASE_URL= ConfigManager.getInstance().getString("baseUrl");
    private static final String BASE_PATH = "api/users";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestResponseSpecification() {
        requestSpec = new RequestSpecBuilder().setBaseUri(BASE_URL).setBasePath(BASE_PATH).build();
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @DataProvider(name = "getSingleUserTestData")
    public Object[][] getSingleUserTestData() {
        return new Object[][]{
                {"1", "George", "Bluth"},
                {"2", "Janet", "Weaver"},
                {"3", "Emma", "Wong"}
        };
    }

    @Test(dataProvider = "getSingleUserTestData")
    public void requestSingleUser_validateFirstNameLastName(String id, String firstName, String lastName) {

        given().
                spec(requestSpec)
                .pathParam("id", id).
                when()
                .get("{id}").
                then()
                .spec(responseSpec)
                .assertThat().body("data.first_name", equalTo(firstName)).and()
                .body("data.last_name", equalTo(lastName));
    }
}
