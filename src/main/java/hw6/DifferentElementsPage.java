package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    private static DifferentElementsPage instance;

    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[@type='radio']")
    private List<WebElement> radios;

    @FindBy(tagName = "select")
    private List<WebElement> dropDowns;

    @FindBy(xpath = "//*[contains(@value, 'Button')]")
    private List<WebElement> buttons;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(xpath = "//*[@name='log-sidebar']")
    private WebElement rightSection;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElementsPage(driver);
        }
        return instance;
    }


//    ELEMENT GETTERS

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropDowns() {
        return dropDowns;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getCheckbox(String checkbox) {
        return driver.findElement(By.xpath("//*[@class='label-checkbox' and contains(., '" + checkbox + "')]//input"));
    }

    public WebElement findLogRow(String artifact, String boolValue) {
        return driver.findElement(By.xpath("//*[contains(@class, 'logs')]//*[contains(text(), " +
                "'" + artifact + "') and contains(text(), '" + boolValue + "')]"));
    }

    public void selectRadioButton(String radioButtonName) {
        driver.findElement(By.xpath("//*[@class='label-radio' and contains(., '" + radioButtonName + "')]")).click();
    }

    public WebElement getRadioButtonByName(String radioButtonName) {
        return driver.findElement(By.xpath("//*[@class='label-radio' and contains(., '" + radioButtonName + "')]//input"));
    }

    public WebElement findMetalLogRow(String artifact) {
        return driver.findElement(By.xpath("//*[contains(@class, 'logs')]//*[contains(text(), 'metal') and contains(text(), '" + artifact + "')]"));
    }

    public void selectDropdownOption(String option) {
        driver.findElement(By.xpath("//option[contains(text(), '" + option + "')]")).click();
    }

    public WebElement getDropdownOption(String option) {
        return driver.findElement(By.xpath("//option[contains(text(), '" + option + "')]"));
    }

    public WebElement findColorLogRow(String color) {
        return driver.findElement(By.xpath("//*[@class='panel-body-list logs']//*[contains(text(), '" + color + "')]"));
    }

}
