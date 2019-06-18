package lesson3;

import lesson3.enums.LeftSideMenu;
import org.openqa.selenium.By;
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

    public void setLastNameTextField(String text) {
        lastNameTextField.sendKeys(text);
    }

    public void selectGender(String gender) {
        new Select(genderSelect).selectByVisibleText(gender);
    }

    public String getGenderDropdownValue() {
        return genderSelect.getAttribute("value");
    }

    public void clickLeftSideMenu(LeftSideMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

}
