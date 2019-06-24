
package lesson4;

import lesson4.builder.User;
import lesson4.builder.UserLombok;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Example2 {

    @Test
    public void builderTest() {
        User user = User.getBuilder()
                .setName("Andrei")
                .setAddress("Z22")
                .setAge(30)
                .setEmail("andrei@epam.com")
                .build();
        System.out.println(user);

        user = User.getBuilder()
                .setName("Mikhail")
                .setAge(20)
                .build();

        System.out.println(user);
    }

    @DataProvider(name = "builder")
    public static Object[][] builder() {
        return new Object[][]{
                {UserLombok.builder()
                        .address("L11")
                        .name("Rita")
                        .build()},
                {UserLombok.builder()
                        .name("Ivan")
                        .age(21)
                        .build()}
        };
    }

    @Test(dataProvider = "builder")
    public void lombokBuilderTest(UserLombok user) {
        System.out.println(user);
    }
}