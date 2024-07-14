package June.Ex22062024.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab016 {

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
    String bookingId = "211";
    String token = "9136f75c0e03b20";
    String UPDATED_BASE_PATH = BASE_PATH + "/" + bookingId;

    @Test
    public void deleteRequest(){
        rs.baseUri(BASE_URL).basePath(UPDATED_BASE_PATH);
        rs.contentType(ContentType.JSON).cookie("token", token).log().all();

        response= rs.when().log().all().delete();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
