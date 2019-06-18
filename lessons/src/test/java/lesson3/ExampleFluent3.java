package lesson3;

import base.BaseTest;
import lesson3.enums.LeftSideMenu;
import lesson3.fluent.ContactFormPage;
import lesson3.fluent.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleFluent3 extends BaseTest {

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