package June.Ex27062024.PayloadFromFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class Lab040 {

    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;
    @Test
    public void PushReq(){
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        File payload =new File("src/test/resources/payload.json");

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
