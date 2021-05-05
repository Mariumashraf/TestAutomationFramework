package levelset.apis.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public void request_postReq() {
        given().log().all().
                baseUri("https://reqres.in").
                and().contentType(ContentType.JSON).and().body("{\n" +
                "\"name\" : \"Marium\",\n" +
                "\"job\":\"Test Automation Engineer\"\n" +
                "}").when().
                post("/api/users").then().log().all();
    }

    @Test
    public void request_putReq() {
        given().log().all().
                baseUri("https://reqres.in").and().contentType(ContentType.JSON).
                and().and().pathParam("userId", 4).body("{\n" +
                "\"name\": \"Marium Ashraf\",\n" +
                "\"job\": \"Tester\"\n" +
                "}").when().
                put("/api/users/{userId}").then().log().all();


    }
}
