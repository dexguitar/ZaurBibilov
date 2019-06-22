package lesson3.fluent;

import lesson3.enums.LeftSideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    @CacheLookup
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        return this;
    }

    public ContactFormPage clickContactFormMenuItem() {
        clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
        return new ContactFormPage(driver);
    }

    private void clickLeftSideMenu(LeftSideMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }


}