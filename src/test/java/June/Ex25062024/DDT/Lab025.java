package June.Ex25062024.DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab025 {
    // Data Driven Testing - TestNG
    // Mix the Data Driven with the Apache POI
    // Data Driven Testing -. Running a Single Test case with Multiple Inputs
    // Login Test - 100 U/P

    @DataProvider
    public Object[][] getdata(){

        return new Object[][]{
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password123"},
                new Object[]{"admin1", "pwd123"}
        };

    }


    @DataProvider
    public Object[][] getExcelData(){
        // ApachePOI CODE
        // Read a Excel File which contain the data and give to the getData Function
        return null;
    }

    @Test(dataProvider = "getdata")
    public void getAuthCred(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
