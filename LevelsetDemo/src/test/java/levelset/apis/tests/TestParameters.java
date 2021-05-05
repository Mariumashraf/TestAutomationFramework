package levelset.apis.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestParameters {

    @Test
    public void request_queryParms() {
        given().
                baseUri("https://reqres.in").
                and().
                //query>> key + value
                        queryParam("page", 2).
                and().
                queryParam("per_page", 3).
                and().
                header("Accept", "*/*").
                and().
                header("Connection", "keep-live").
                when().
                get("/api/users").
                then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void request_pathParms() {
        given().
                baseUri("https://reqres.in").
                and().
                //path>> part of path
                        pathParam("userId", 3).
                when().
                get("/api/users/{userId}").
                then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void request_pathAndQyeryParms() {
        given().
                log().all()
                .baseUri("https://reqres.in")
                .and().queryParam("page", 2).
                and().
                queryParam("per_page", 3).
                and().pathParam("userId", 4).
                and().
                header("Accept", "*/*").
                and().
                header("Connection", "keep-live").
                when().
                get("/api/users/{userId}").then()
                .log().all();

    }
}
