package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiffElementsPage extends BasePage {

    // TODO Why is public?
    public static final String DIFF_ELEMENTS_PAGE_LINK = "https://epam.github.io/JDI/different-elements.html";

    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[@type='radio']")
    private List<WebElement> radios;

    @FindBy(xpath = "//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//*[contains(@value, 'Button')]")
    private List<WebElement> buttons;

    @FindBy(xpath = "//*[contains(@class, 'right-fix-panel')]")
    private WebElement rightSection;

    @FindBy(xpath = "//*[@class='sidebar-menu']")
    private WebElement leftSection;

    @FindBy(xpath = "//*[@class='label-checkbox' and contains(., 'Water')]//input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//*[@class='label-checkbox' and contains(., 'Wind')]//input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//li[contains(text(), 'Water') " +
            "and contains(text(), 'true')]")
    private WebElement waterLogRowTrue;

    @FindBy(xpath = "//li[contains(text(), 'Wind') " +
            "and contains(text(), 'true')]")
    private WebElement windLogRowTrue;

    @FindBy(xpath = "//li[contains(text(), 'Water') " +
            "and contains(text(), 'false')]")
    private WebElement waterLogRowFalse;

    @FindBy(xpath = "//li[contains(text(), 'Wind') " +
            "and contains(text(), 'false')]")
    private WebElement windLogRowFalse;

    @FindBy(xpath = "//*[@class='label-radio' " +
            "and contains(., 'Selen')]//input")
    private WebElement selenCheckbox;

    @FindBy(xpath = "//li[contains(text(), 'metal') " +
            "and contains(text(), 'Selen')]")
    private WebElement selenLogRow;

    @FindBy(xpath = "//option[contains(text(), 'Yellow')]")
    private WebElement yellowDropdownOption;

    @FindBy(xpath = "//li[contains(text(), 'Colors') and contains(text(), 'Yellow')]")
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