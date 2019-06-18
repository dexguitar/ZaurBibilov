package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

}
