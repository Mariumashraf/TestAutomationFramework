package apis.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetExamples {
    @Test(priority = 1)
    public void request_checkResponseCode_expect200() {
        given().baseUri("https://reqres.in").
                when().
                get("/api/users").
                then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test(priority = 2, dependsOnMethods = "request_checkResponseCode_expect200")
    public void request_logging() {
        given().baseUri("https://reqres.in").
                when().
                get("/api/users").
                then().log().all();
        //then().log().headers();
        //then().log().body();
    }

}
