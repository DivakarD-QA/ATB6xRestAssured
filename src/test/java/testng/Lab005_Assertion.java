package testng;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab005_Assertion {

    @Description("Assertion")
    @Test
    public void testCase(){

        // Assertion ->  Expect Result = Actual Result
        // 200 == 200

        // Two Types Assertions

        // Soft Assertions


        SoftAssert s = new SoftAssert();
        s.assertEquals("pramod","pramod","Not Equal");
        s.assertEquals("amit","amith","Not Equal");
        System.out.println("End of the Program1");
        s.assertAll();


        // PUT -> token


        // Hard Assertion

        Assert.assertEquals("pramod","Pramod");
        Assert.assertEquals(23,23,"Not Equal");
        System.out.println("End of the program2");



    }
}
