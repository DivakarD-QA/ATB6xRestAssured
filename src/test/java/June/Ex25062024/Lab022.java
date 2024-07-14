package June.Ex25062024;

import org.testng.annotations.Test;

public class Lab022 {
    // dependsON Method


    @Test(priority = 0)
    public void startServer(){
        System.out.println("I will run first - 1");
    }

    @Test(dependsOnMethods = "startServer", priority = 0)
    public void method1(){
        System.out.println("Method1 started ");
    }
    @Test(priority = 1)
    public void getToken() {
        System.out.println("I will run first - 2");
    }
    @Test(priority = 1)
    public void getBookingID() {
        System.out.println("I will run first - 3");
    }



    @Test(dependsOnMethods = {"getToken", "getBookingID"}, priority = 1)
    public void method2(){
        System.out.println("Method 2 Started");
    }

    @Test(groups = "Regression", priority = 1)
    public void openApp(){
        System.out.println("OPening app");
    }

    @Test(groups = "Regression", priority = 2)
    public void enterCred(){
        System.out.println("Entering UserName and Password");
        }


    @Test(dependsOnGroups = "Regression")
    public void clickLOginBtn(){
        System.out.println("Click on Login button");
    }


}
