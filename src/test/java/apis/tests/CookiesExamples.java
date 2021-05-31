package apis.tests;

import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CookiesExamples {

    @Test
    public void cookiesFirstTech() {
        given().
                baseUri("https://reqres.in/").
                cookie("CookieKey", "CookieValue").
                log().all().
                when().
                get("api/users/2").
                then().
                assertThat().
                statusCode(200);

    }

    @Test
    public void cookieSecondTech() {
        Cookie cookie = new Cookie.Builder("Cookie", "Value").setMaxAge(5000).build();
        given().
                baseUri("https://reqres.in/").
                cookie("CookieKey", "CookieValue").
                cookie(cookie).
                log().all().
                when().
                get("api/users").
                then().log().all().
                assertThat().
                statusCode(200);

    }

    @Test
    public void jsonValidation() {

        Response response = given().
                baseUri("https://reqres.in/").
                when().
                get("api/users/2").
                then().log().all().extract().response();
        JsonPath jsonPath = response.jsonPath();
        System.out.println((String) jsonPath.get("data.email"));
        Assert.assertEquals(jsonPath.get("data.email"),"janet.weaver@reqres.in");

    }
}
