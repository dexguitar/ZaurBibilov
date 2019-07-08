package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    @FindBy(tagName = "select")
    private List<WebElement> numberDropdowns;

    @FindBy(xpath = "//td[contains(., '')]//a")
    private List<WebElement> userNames;

    @FindBy(xpath = "//*[@id='user-table']//img")
    private List<WebElement> images;

    @FindBy(xpath = "//*[@id='user-table']//span")
    private List<WebElement> textDescriptions;

    @FindBy(xpath = "//*[@id='user-table']//*[@type='checkbox']")
    private List<WebElement> checkboxes;

    private UserTablePage(WebDriver driver) {
        super(driver);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }

        return instance;
    }

    public static void killObject(WebDriver driver) {
        if (instance != null) {
            instance = null;
        }
    }


//    ELEMENT GETTERS

    public List<WebElement> getNumberDropdowns() {
        return numberDropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTextDescriptions() {
        return textDescriptions;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }


//    Specials

    public String getUsernumber(String num) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + num + "')]")).getText();
    }

    public String getUsername(String username) {
        return driver.findElement(By.xpath("//a[contains(text(), '" + username + "')]")).getText();
    }

    public String getDescription(String description) {
        return driver.findElement(By.xpath("//span[contains(text(), '" + description + "')]")).getText();
    }

    public void clickCheckbox(String userName) {
        driver.findElement(By.xpath("//tr[contains(., '" + userName + "')]//input")).click();
    }

    public WebElement getLogRow(String text) {
        return driver.findElement(By.xpath("//li[contains(text(), '" + text + "')]"));
    }

    public void clickDropdownForUser(String user) {
        driver.findElement(By.xpath("//tr[contains(., '" + user + "')]//select")).click();
    }

    public List<WebElement> getDropdownContentsForUser(String user) {
        return driver.findElements(By.xpath("//tr[contains(., '" + user + "')]//option"));
    }

}
