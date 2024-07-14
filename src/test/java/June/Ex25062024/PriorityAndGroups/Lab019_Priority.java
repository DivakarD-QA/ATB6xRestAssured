package June.Ex25062024.PriorityAndGroups;

import org.testng.annotations.Test;

public class Lab019_Priority {

    // TestNG Priority in Java
    // TestNG also allows the use of negative priority values.

    @Test(priority = 0)
    public void getmethodOne(){
        System.out.println("1");
    }
    @Test(priority = 1)
    public void getmethodTwo(){
        System.out.println("2");
    }
    @Test(priority = 2)
    public void getmethodThree(){
        System.out.println("3");
    }
    @Test(priority = 3)
    public void getmethodNegative(){
        System.out.println("-1");
    }




}
