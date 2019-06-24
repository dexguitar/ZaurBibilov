package lesson3;

import base.BaseTest;
import lesson3.steps.ContactFormPageSteps;
import lesson3.voids.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleSteps3 extends BaseTest {

    ContactFormPageSteps contactFormPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        contactFormPageSteps = new ContactFormPageSteps(driver);
    }

    @Test
    public void simpleStepTest() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.login("epam", "1234");

        contactFormPageSteps.goToContactFormPage();
        contactFormPageSteps.fillContactFormData("Male", "Some name");

        // assert
    }
}