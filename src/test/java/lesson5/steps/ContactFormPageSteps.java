package lesson5.steps;

import io.qameta.allure.Step;
import lesson3.enums.LeftSideMenu;
import lesson5.ContactFormPage;
import lesson5.TestProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class ContactFormPageSteps {

    private WebDriver driver;

    private ContactFormPage contactFormPage;

    public ContactFormPageSteps(WebDriver driver) {
        this.driver = driver;
        TestProvider.getInstance().setDriver(driver);
        contactFormPage = new ContactFormPage(driver);
    }

    @Step("Navigate to Contact Form page")
    public void goToContactFormPage() {
        contactFormPage.clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
    }

    @Step("Fill Contact Form")
    public void fillContactFormData(String gender, String lastName) {
        contactFormPage.selectGender(gender);
        contactFormPage.setTextLastNameTextField(lastName);
    }

    @Step("Check user name {0}")
    public void checkUserName(String userName) {
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), userName);
    }
}