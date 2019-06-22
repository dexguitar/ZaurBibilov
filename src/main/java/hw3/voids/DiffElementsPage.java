package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiffElementsPage extends BasePage {

    public static final String DIFF_ELEMENTS_PAGE_LINK = "https://epam.github.io/JDI/different-elements.html";

    @FindBy(xpath = "//*[@class='checkbox-row'][1]//label")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[@class='checkbox-row'][2]//label")
    private List<WebElement> radios;

    @FindBy(xpath = "//*[@class='colors']//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//*[@class='main-content-hg']//*[contains(@value, 'Button')]")
    private List<WebElement> buttons;

    @FindBy(xpath = "//*[@class='uui-side-bar right-fix-panel mCustomScrollbar _mCS_2 mCS_no_scrollbar']")
    private WebElement rightSection;

    @FindBy(xpath = "//*[@class='sidebar-menu']")
    private WebElement leftSection;

    @FindBy(xpath = "//*[@class='label-checkbox'][1]//input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//*[@class='label-checkbox'][3]//input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[contains(text(), 'Water: condition changed to true')]")
    private WebElement waterLogRowTrue;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[contains(text(), 'Wind: condition changed to true')]")
    private WebElement windLogRowTrue;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[contains(text(), 'Water: condition changed to false')]")
    private WebElement waterLogRowFalse;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[contains(text(), 'Wind: condition changed to false')]")
    private WebElement windLogRowFalse;

    @FindBy(xpath = "//*[@class='label-radio'][4]//input")
    private WebElement selenCheckbox;

    @FindBy(xpath = "//*[@class='panel-body-list logs']//li[contains(text(), 'metal: value changed to  Selen')]")
    private WebElement selenLogRow;

    @FindBy(xpath = "//select[@class='uui-form-element']//option[contains(text(), 'Yellow')]")
    private WebElement yellowDropdownOption;

    @FindBy(xpath = "//*[@class='panel-body-list logs']//li[contains(text(), 'Colors: value changed to Yellow')]")
    private WebElement colorLogRow;

    public DiffElementsPage(WebDriver driver) {
        super(driver);
    }

    public String getDiffElementsPageUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    public WebElement getWindCheckbox() {
        return windCheckbox;
    }

    public WebElement getWaterLogRowTrue() {
        return waterLogRowTrue;
    }

    public WebElement getWindLogRowTrue() {
        return windLogRowTrue;
    }

    public WebElement getWaterLogRowFalse() {
        return waterLogRowFalse;
    }

    public WebElement getWindLogRowFalse() {
        return windLogRowFalse;
    }

    public WebElement getSelenCheckbox() {
        return selenCheckbox;
    }

    public WebElement getSelenLogRow() {
        return selenLogRow;
    }

    public WebElement getYellowDropdownOption() {
        return yellowDropdownOption;
    }

    public WebElement getColorLogRow() {
        return colorLogRow;
    }

}