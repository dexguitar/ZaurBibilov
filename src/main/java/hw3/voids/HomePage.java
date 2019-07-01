package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public static final String JDI_LINK_URL = "https://github.com/epam/JDI";

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(id = "user-name")
    private WebElement topRightUserName;

    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> menu;

    @FindBy(xpath = "//div[@class='benefit-icon']//span")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> texts;

    @FindBy(className = "main-title")
    private WebElement mainTitle;

    @FindBy(className = "main-txt")
    private WebElement mainText;

    @FindBy(tagName = "iframe")
    private WebElement iFrame;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement subHeader;

    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement jdiLink;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li")
    private List<WebElement> serviceDropdownContents;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li//a[contains(text(), 'Different elements')]")
    private WebElement differentElementsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame() {
        driver.switchTo().frame("iframe");
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public List<String> getServiceDropdownContents() {
        List<String> contents = new ArrayList<>();
        for (WebElement element : serviceDropdownContents) {
            contents.add(element.getText());
        }
        return contents;
    }

    public String getTopRightUserName() {
        return topRightUserName.getText();
    }

    public List<WebElement> getMenuItems() {
        return menu;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getMainText() {
        return mainText;
    }

    public WebElement getiFrame() {
        return iFrame;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public WebElement getJdiLink() {
        return jdiLink;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getDifferentElementsLink() {
        return differentElementsLink;
    }

}