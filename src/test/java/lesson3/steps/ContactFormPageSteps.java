package lesson3.steps;

import lesson3.enums.LeftSideMenu;
import lesson3.voids.ContactFormPage;
import org.openqa.selenium.WebDriver;

public class ContactFormPageSteps {

    private WebDriver driver;

    private ContactFormPage contactFormPage;

    public ContactFormPageSteps(WebDriver driver) {
        this.driver = driver;
        contactFormPage = new ContactFormPage(driver);
    }

    public void goToContactFormPage() {
        contactFormPage.clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
    }

    public void fillContactFormData(String gender, String lastName) {
        contactFormPage.selectGender(gender);
        contactFormPage.setTextLastNameTextField(lastName);
    }
}