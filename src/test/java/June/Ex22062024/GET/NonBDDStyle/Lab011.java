package June.Ex22062024.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab011 {

    @Test
    public void getRequestNonBDD(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/560037");
        r.when().log().all().get();
        r.then().statusCode(200).log().all();
    }

    @Test
    public void getRequestNonBDD2(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/560037");
        r.when().log().all().get();
        r.then().statusCode(201).log().all();
    }
}
