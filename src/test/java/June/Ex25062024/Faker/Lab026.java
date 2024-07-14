package June.Ex25062024.Faker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab026 {

    @Test
    public void faker(){
        Faker faker = new Faker();
        String UN = faker.name().username();
        String PW = faker.phoneNumber().phoneNumber();
        System.out.println(UN);
        System.out.println(PW);
    }
}
