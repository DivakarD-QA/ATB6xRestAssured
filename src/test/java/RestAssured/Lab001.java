package RestAssured;

import io.restassured.RestAssured;

public class Lab001 {
    // Rest Assured Hello World Program
    public static void main(String[] args) {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);



    }



}
