package June.Ex22062024.FULL;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab017 {

    @BeforeTest
    public void getAToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }
    @Test
    public void t3(){
        // token and BookingID
        System.out.println("3");
    }

}
