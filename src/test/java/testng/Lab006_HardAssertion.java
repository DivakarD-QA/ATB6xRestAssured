package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab006_HardAssertion {
    @Test
    public void testCase1(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void testCase2(){
        Assert.assertEquals(false, true);
    }
}
