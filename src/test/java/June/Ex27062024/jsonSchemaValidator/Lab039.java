package June.Ex27062024.jsonSchemaValidator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.when;

public class Lab039 {


    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;

    @Test
    public void jsonVal(){

        RestAssured.given().baseUri("https://jsonplaceholder.typicode.com/posts/2")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema.json")));

    }
}
