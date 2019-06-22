package lesson4;

import com.codeborne.selenide.SelenideElement;
import lesson3.enums.LeftSideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class HomePage {

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginNameTextField;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        $("#password").sendKeys(password);
        loginButton.click();
    }

    public void clickLeftSideMenu(LeftSideMenu menuItem) {
        element(By.linkText(menuItem.getName())).click();
    }

}