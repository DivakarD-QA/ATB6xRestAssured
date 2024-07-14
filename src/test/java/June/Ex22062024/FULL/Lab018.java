package June.Ex22062024.FULL;

import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Lab018 {

    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;

    String BASE_URl = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

@BeforeTest

    public void getToken(){

    System.out.println("Get Token is running ..........");
    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    requestSpecification.baseUri(BASE_URl).basePath("/auth");
    requestSpecification.contentType(ContentType.JSON).body(payload).log().all();

    response = requestSpecification.when().post();

    validatableResponse =response.then().log().all();
    validatableResponse.statusCode(200);

    token= validatableResponse.log().all().extract().path("token");
    Assert.assertNotNull(token);



}


@BeforeTest

    public void createBooking(){
    System.out.println("Create Booking is running ..........");
    String payload = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    requestSpecification.baseUri(BASE_URl).basePath(BASE_PATH);
    requestSpecification.contentType(ContentType.JSON).body(payload);

    response = requestSpecification.when().log().all().post();

    validatableResponse = response.then().log().all();
    String responseToString = response.asString();
    System.out.println(responseToString);
    validatableResponse.statusCode(200);

    bookingId = validatableResponse.log().all().extract().path("bookingid");
    String firstname = validatableResponse.log().all().extract().path("booking.firstname");

    System.out.println("Booking ID --- " + bookingId);
    System.out.println("FirstName --- " + firstname);
    Assert.assertNotNull(bookingId);

}

    @Test
    public void putRequest(){

        // token and BookingID
        System.out.println(" Test Case PUT Request running ..........");
    String payload = "{\n" +
            "    \"firstname\" : \"MIA\",\n" +
            "    \"lastname\" : \"Romeo\",\n" +
            "    \"totalprice\" : 123,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2024-01-01\",\n" +
            "        \"checkout\" : \"2024-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast,lunch\"\n" +
            "}";

    String Update_BASE_PATH = BASE_PATH + "/" + bookingId;
    requestSpecification.baseUri(BASE_URl).basePath(Update_BASE_PATH);
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token", token);
    requestSpecification.body(payload).log().all();


        // Put Request
        requestSpecification.body(payload).log().all();

    response = requestSpecification.when().put();

    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);

    String fullResponseToString = response.asString();
        System.out.println(fullResponseToString);

        // 3 Ways You can verify the response

        // 1. RA - Matchers

        validatableResponse.body("firstname", Matchers.equalTo("MIA"));
        validatableResponse.body("lastname", Matchers.equalTo("Romeo"));

        //  2. TestNG Asserts -

        String firstnamePath = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstnamePath, "MIA");

        // 3 TestNG Assertion with JSON Path Lib

        JsonPath jsonPath = new JsonPath(fullResponseToString);
        String firstNameJSONPath = jsonPath.getString("firstname");
        String lastNameJSONPath = jsonPath.getString("lastname");
        Integer totalPriceJSONPath = jsonPath.getInt("totalprice");
        String checkinJSONPath = jsonPath.getString("bookingdates.checkin");

        Assert.assertEquals(firstNameJSONPath,"MIA");
        Assert.assertEquals(lastNameJSONPath, "Romeo");
        Assert.assertEquals(totalPriceJSONPath, 123);
        Assert.assertEquals(checkinJSONPath, "2024-01-01");
        Assert.assertNotNull(checkinJSONPath);


        // 4. AssertJ Matching

        assertThat(firstNameJSONPath).isEqualTo("MIA").isNotEmpty().isNotNull();
        assertThat(totalPriceJSONPath).isPositive().isNotZero();







    }




}
