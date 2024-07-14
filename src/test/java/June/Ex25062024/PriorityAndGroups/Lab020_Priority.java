package June.Ex25062024.PriorityAndGroups;

import org.testng.annotations.Test;

public class Lab020_Priority {
    @Test(priority = 1)
    public void testMethodB() {
        System.out.println("Test Method B");
    }

    @Test(priority = 1)
    public void testMethodA() {
        System.out.println("Test Method A");
    }

    @Test(priority = 1)
    public void testMethodC() {
        System.out.println("Test Method C");
    }
}
