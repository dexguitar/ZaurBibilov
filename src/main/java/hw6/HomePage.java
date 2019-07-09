package hw6;

import hw6.enums.ServiceDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private static HomePage instance;

    @FindBy(xpath = "//*[@name='main-title']")
    private WebElement mainTitle;

    @FindBy(xpath = "//*[@name='jdi-text']")
    private WebElement description;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='benefit-icon']//span")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a")
    private List<WebElement> serviceDropdown;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    public static void killObject(WebDriver driver) {
        if (instance != null) {
            instance = null;
        }
    }

//    ELEMENT GETTERS
    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getDescription() {
        return description;
    }

    public List<WebElement> getServiceDropdown() {
        return serviceDropdown;
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getLoginNameTextField() {
        return loginNameTextField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public void clickServiceDropdownItem(ServiceDropdown item) {
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[contains(., '" +
                item.getName() + "')]")).click();
    }

    public void clickCheckbox(String checkboxName) {
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(., '" + checkboxName + "')]")).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

}