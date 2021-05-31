package apis.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class RequestResponseSpec {
    /*First Test Case "post request with add request and response specifications and using json file"*/

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://reqres.in/").
                addCookie("Key", "firstValue", "Key2", "secondValue").
                setContentType(ContentType.JSON).build();


        responseSpecification = new ResponseSpecBuilder().expectStatusCode(201).
                expectContentType(ContentType.JSON).build();
    }

    @Test
    public void postUserWithSpecifications() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("resources/body.json");
        String streamBody = new String(IOUtils.toByteArray(fileInputStream));
        given().log().all().
                spec(requestSpecification).
                and().
                contentType(ContentType.JSON).
                and().body(streamBody).
                when().
                post("/api/users").
                then().spec(responseSpecification).
                log().all().
                assertThat().
                body("name", equalTo("Marium"),
                        "job", equalTo("Test Automation Engineer"));
    }


    /*Second Test Case Get request using DataProvider*/

    @Test(dataProvider = "dataReader", priority = 2)
    public void jsonValidation(int id, String email, String firstName, String lastName) {

        Response response = given().
                baseUri("https://reqres.in/").
                and().pathParam("userId", id).
                when().
                get("api/users/{userId}").
                then().extract().response();
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("data.email"), email);
        assertEquals(jsonPath.get("data.first_name"), firstName);
        assertEquals(jsonPath.get("data.last_name"), lastName);


    }

    @DataProvider(name = "dataReader")
    public static Object[][] dataReader() {
        return new Object[][]{
                {2, "janet.weaver@reqres.in", "Janet", "Weaver"},
                {3, "emma.wong@reqres.in", "Emma", "Woong"},
                {4, "eve.holt@reqresd.in", "Eve", "Holt"}
        };
    }
}
