package lesson3;

import base.BaseLessonTest;
import lesson3.fluent.ContactFormPage;
import lesson3.fluent.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleFluent3 extends BaseLessonTest {

    @Test
    public void contactPageTest() {
        ContactFormPage cfp = new HomePage(driver)
                .login("epam", "1234")
                .clickContactFormMenuItem();

        String actual = cfp.setTextLastNameTextField("Last Name")
                .selectGender("Female")
                .getGenderDropdownValue();

        assertEquals(actual, "Female");
    }

}