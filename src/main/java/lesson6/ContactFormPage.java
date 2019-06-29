package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactFormPage extends BasePage {

    @FindBy(id = "last-name")
    private WebElement lastNameTextField;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    public ContactFormPage(WebDriver driver) {
        super(driver);
    }

    public void setTextLastNameTextField(String text) {
        lastNameTextField.sendKeys(text);
    }

    public void selectGender(String gender) {
        new Select(genderSelect).selectByVisibleText(gender);
    }

    public String getGenderDropdownValue() {
        return genderSelect.getAttribute("value");
    }

}