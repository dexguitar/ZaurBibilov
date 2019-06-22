package lesson3.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactFormPage {

    private WebDriver driver;

    @FindBy(id = "last-name")
    private WebElement lastNameTextField;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    public ContactFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactFormPage setTextLastNameTextField(String text) {
        lastNameTextField.sendKeys(text);
        return this;
    }

    public ContactFormPage selectGender(String gender) {
        new Select(genderSelect).selectByVisibleText(gender);
        return this;
    }

    public String getGenderDropdownValue() {
        return genderSelect.getAttribute("value");
    }
}