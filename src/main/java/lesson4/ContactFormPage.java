package lesson4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ContactFormPage {

    @FindBy(id = "last-name")
    private SelenideElement lastNameTextField;

    @FindBy(id = "gender")
    private SelenideElement genderSelect;

    public ContactFormPage() {
        Selenide.page(this);
    }

    public void setTextLastNameTextField(String text) {
        lastNameTextField.sendKeys(text);
    }

    public void selectGender(String gender) {
        genderSelect.selectOptionContainingText(gender);
    }

    public SelenideElement getGenderDropdownValue() {
        return genderSelect;
    }

}