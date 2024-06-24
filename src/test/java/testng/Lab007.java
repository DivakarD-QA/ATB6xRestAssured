package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab007 {


    // Integration
    // Create Booking, -> ID
    // Create Auth  -> Token
    // PUT -> ID, Token
    // Delete -> ID
    // GET -> ID -- verify it should not exist.


    String token;
    Integer bookingid;

    public String gettoken(){
        token = "12E4";
        return token;
    }

    @Test
    public void getBooking(){

        System.out.println(" GET ");
        System.out.println("token");
        System.out.println("bookingid");
        System.out.println( " ---- ---- ----");
        //GET
    }
    @BeforeTest
    public void postBooking(){
        token = gettoken();
        System.out.println(" POST ");
        System.out.println("token");
        System.out.println("bookingid");
        System.out.println( " ---- ---- ----");
        //POST
    }




    @Test
    public void updateBooking(){

        System.out.println(" PATCH ");
        System.out.println("token");
        System.out.println("bookingid");
        System.out.println( " ---- ---- ----");
        //Update
    }

    @Test
    public void deleteBooking(){

        System.out.println(" DELETE ");
        System.out.println("token");
        System.out.println("bookingid");
        System.out.println( " ---- ---- ----");
        //Delete
    }

}
