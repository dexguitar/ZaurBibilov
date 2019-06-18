package lesson3.steps;

import lesson3.ContactFormPage;
import org.openqa.selenium.WebDriver;

public class ContactFormPageSteps {

    private WebDriver driver;

//    NOT cfp cuz it's a FIELD!!!
    private ContactFormPage contactFormPage;

    public ContactFormPageSteps(WebDriver driver) {
        this.driver = driver;
        contactFormPage = new ContactFormPage(driver);
    }
}