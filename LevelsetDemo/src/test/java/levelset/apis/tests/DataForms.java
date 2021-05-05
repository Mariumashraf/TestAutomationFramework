package levelset.apis.tests;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DataForms {
    @Test
    public void request_postReqByJson() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/apiTestData/body.json");
        String streamBody = new String(IOUtils.toByteArray(fileInputStream));
        given().log().all().
                baseUri("https://reqres.in").
                and().
                contentType(ContentType.JSON).
                and().body(streamBody).
                when().
                post("/api/users").
                then().log().all().
                assertThat().
                statusCode(201);
    }

    @Test
    public void request_postReqByPara() throws IOException {
        String valueOfName = "Mero";
        String valueOfJob = "Tester";
        String userResources = "users";
        given().log().all().
                baseUri("https://reqres.in").
                and().contentType(ContentType.JSON).and().body("{\n" +
                "\"name\" : \"" + valueOfName + "\",\n" +
                "\"job\":\"" + valueOfJob + "\"\n" +
                "}").when().
                post("/api/"+userResources).then().log().all();

    }

    @DataProvider(name = "dataReader")
    public static Object[][] dataReader(){
        return new Object[][]{
                {"Mariam","Tester","users"},
                {"Mero","Tester","users"}
        };
    }

    @Test(dataProvider = "dataReader")
    public void request_postReqByDataProv(String name, String job, String users) throws IOException {
        given().log().all().
                baseUri("https://reqres.in").
                and().contentType(ContentType.JSON).and().body("{\n" +
                "\"name\" : \"" + name + "\",\n" +
                "\"job\":\"" + job + "\"\n" +
                "}").when().
                post("/api/"+users).then().log().all();

    }
}
