package June.Ex25062024;

import org.testng.annotations.Test;

public class Lab023 {

    @Test(groups = { "init" },priority = 1)
    public void getToken() {
        System.out.println("serverStartedOk");
    }

    @Test(groups = { "init" },priority = 2)
    public void getBookingID() {
        System.out.println("initEnvironment");
    }
    @Test(groups = "init", priority = 1)
    public void openApp(){
        System.out.println("OPening app");
    }

    @Test(dependsOnGroups = { "init.*" })
    public void testPutReq() {
        System.out.println("Now I will run");
    }
}
