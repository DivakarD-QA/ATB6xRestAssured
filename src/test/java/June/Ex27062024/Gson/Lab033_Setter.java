package June.Ex27062024.Gson;

import June.Ex27062024.Gson.Sereliazation.Booking;
import June.Ex27062024.Gson.Sereliazation.Bookingdates;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab033_Setter {

    // Most Used - Class and Objects.
    // Swagger API - Document , File IO Binary File Payload
    // Non BDD - API Automation -

    // Cucumber BDD  - suite - Framework -. Cucumber BDD (Feature Files, Glue Other)


    // Payload -> RA -> Class or Objects -> JSONString ( Who Help, Library) - Serialization
    // Response -> jsonString -> Class or OBject ( Deserialization)

    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;


    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Bond");
        booking.setTotalprice(134);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Service,Night");

        System.out.println(booking);


    }

}
