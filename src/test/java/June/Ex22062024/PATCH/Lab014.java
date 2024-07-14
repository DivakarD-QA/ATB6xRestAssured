package June.Ex22062024.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class Lab014 {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
    String bookingId = "179";
    String token = "3e43ae139610b7c";
    String UPDATED_BASE_PATH = BASE_PATH + "/" + bookingId;

            @Test
    public void patchRequest(){
        String payload="{\n" +
                "    \"firstname\" : \"Mick\"\n" +
                "}";

        rs.baseUri(BASE_URL).basePath(UPDATED_BASE_PATH);
        rs.contentType(ContentType.JSON).cookie("token",token);
        rs.body(payload).log().all();

        response=rs.when().log().all().patch();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Mick"));



    }

}
