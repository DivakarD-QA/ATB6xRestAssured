package June.Ex25062024;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Lab021 {
    // Grouping of Test Cases

    @Issue("TC123")
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sanity Testcase")

    @Test(groups = {"Sanity","QA"}, priority = 1)
public void checkLOgin(){
    System.out.println("Sanity1");
}

  @Test(groups = "Regression", priority = 2)
public void checkPayment(){
    System.out.println("Reg1");
}

    @Test(groups = {"Regression","QA"}, priority = 0)
    public void Payment(){
        System.out.println("Reg2");
    }

    @Test(groups = "Sanity", priority = 1)
public void enterUN(){
    System.out.println("Sanity2");
    }

}
