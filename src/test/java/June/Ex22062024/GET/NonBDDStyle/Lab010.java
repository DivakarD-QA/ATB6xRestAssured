package June.Ex22062024.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class Lab010 {

    public void getRequestNonBDD(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2002");
        r.when().log().all().get();
        r.then().statusCode(200).log().all();
    }

    @Test
    public void getRequestNegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

        // , hEADER, Response Data / bODY


    }
}
