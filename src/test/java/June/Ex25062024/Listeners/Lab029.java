package June.Ex25062024.Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Lab028_CustomListeners.class)
public class Lab029 {
    @Test(groups = "sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(true);
    }

    @Test(groups = "sanity")
    public void test2(){
        System.out.println("test2");
        Assert.assertTrue(true);

    }

    @AfterSuite
    public void emailToQALead(){
        // Send the email
        System.out.println("After Suite Executing......\n");
        System.out.println("Sending Email\n");
    }




}
