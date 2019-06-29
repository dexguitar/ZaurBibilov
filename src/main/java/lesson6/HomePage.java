package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static HomePage instance;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String username) {
        loginNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }
}