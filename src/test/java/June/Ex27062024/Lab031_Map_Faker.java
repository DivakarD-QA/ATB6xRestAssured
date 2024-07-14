package June.Ex27062024;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab031_Map_Faker {
    // PayloadUsingMap
    // POST Request - Payload - String

    //{
    //            "firstname" : "Jim",
    //                "lastname" : "Brown",
    //                "totalprice" : 111,
    //                "depositpaid" : true,
    //                "bookingdates" : {
    //            "checkin" : "2018-01-01",
    //                    "checkout" : "2019-01-01"
    //        },
    //            "additionalneeds" : "Breakfast"
    //        }

    @Test
    public void testPOSTReq() {
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String fuserName = faker.name().firstName();
        String flastName = faker.name().lastName();
        Integer ftotalPrice = faker.random().nextInt(1000);
        Boolean fdepositPaid = faker.random().nextBoolean();

        jsonBodyUsingMap.put("firstname", fuserName);
        jsonBodyUsingMap.put("lastname", flastName);
        jsonBodyUsingMap.put("totalprice", ftotalPrice);
        jsonBodyUsingMap.put("depositpaid", fdepositPaid);


        Map<String,Object> jsonbookingdates = new LinkedHashMap<>();
        jsonbookingdates.put("checkin", "2019-01-01");
        jsonbookingdates.put("checkout", "2022-04-04");

        jsonBodyUsingMap.put("bookingdates", jsonbookingdates);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast,Night");

        System.out.println(jsonBodyUsingMap);

        RequestSpecification r = RestAssured.given();

        Response response;

        ValidatableResponse validatableResponse;

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

}
