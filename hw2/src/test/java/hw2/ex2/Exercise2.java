package hw2.ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest {

    @DataProvider(name = "login data")
    public Object[][] loginData() {
        return new Object[][]{
                {"epam", "1234"}
        };
    }

    @Test(dataProvider = "login data")
    public void differentElementsPageTest(String login, String password) {
//        Open test site by URL
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

//        Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

//        Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

//        Assert User name in the left-top side
//        of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

//        Click on "Service" subcategory in the header
//        and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]")).click();
        List<WebElement> actualDropdownElements = driver.findElements(By.xpath("//*[@class='dropdown open'" +
                "]//ul[@class='dropdown-menu']//li"));
        List<String> dropdownContents = new ArrayList<>();
        for (int i = 0; i < actualDropdownElements.size(); i++) {
            dropdownContents.add(actualDropdownElements.get(i).getText());
        }
        List<String> providedElements = new ArrayList<>();
        providedElements.add("SUPPORT");
        providedElements.add("DATES");
        providedElements.add("COMPLEX TABLE");
        providedElements.add("SIMPLE TABLE");
        providedElements.add("TABLE WITH PAGES");
        providedElements.add("DIFFERENT ELEMENTS");
        assertTrue(dropdownContents.containsAll(providedElements));

//        Open through the header menu
//        Service -> Different Elements Page
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(), 'Different elements')]")).click();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");

//        Check interface on Different elements page,
//        it contains all needed elements:
//        4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='checkbox-row'][1]//label"));
        assertEquals(checkboxes.size(), 4);
        List<WebElement> radios = driver.findElements(By.xpath("//*[@class='checkbox-row'][2]//label"));
        assertEquals(radios.size(), 4);
        List<WebElement> dropdowns = driver.findElements(By.xpath("//*[@class='colors']//select"));
        assertEquals(dropdowns.size(), 1);
        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class='main-content-hg']//" +
                "*[contains(@value, 'Button')]"));
        assertEquals(buttons.size(), 2);

//        Assert that there is Right Section
        assertTrue(driver.findElement(By.xpath("//*[@class='uui-side-bar right-fix-panel mCustomScrollbar" +
                " _mCS_2 mCS_no_scrollbar']")).isDisplayed());

//        Assert that there is Left Section
        assertTrue(driver.findElement(By.xpath("//*[@class='sidebar-menu']")).isDisplayed());

//        Select checkboxes: Water, Wind
        driver.findElement(By.xpath("//*[@class='label-checkbox'][1]//input")).click();
        driver.findElement(By.xpath("//*[@class='label-checkbox'][3]//input")).click();
        assertTrue(driver.findElement(By.xpath("//*[@class='label-checkbox'][1]//input")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@class='label-checkbox'][3]//input")).isSelected());

//        Assert that for each checkbox there is an individual log row
//        and value corresponds to the status of checkbox.
        WebElement waterLogRow = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(text(), " +
                "'Water: condition changed to true')]"));
        assertTrue(waterLogRow.isDisplayed());
        WebElement windLogRow = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(text(), " +
                "'Wind: condition changed to true')]"));
        assertTrue(windLogRow.isDisplayed());

//        Select radio: Selen
        driver.findElement(By.xpath("//*[@class='label-radio'][4]//input")).click();

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        WebElement selenLogRow = driver.findElement(By.xpath("//*[@class='panel-body-list logs']//li[contains(text(), " +
                "'metal: value changed to  Selen')]"));
        assertTrue(selenLogRow.isDisplayed());

//        Select in dropdown: Yellow
        driver.findElement(By.xpath("//select[@class='uui-form-element']//" +
                "option[contains(text(), 'Yellow')]")).click();

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        WebElement colorLogRow = driver.findElement(By.xpath("//*[@class='panel-body-list logs']//" +
                "li[contains(text(), 'Colors: value changed to Yellow')]"));
        assertTrue(colorLogRow.isDisplayed());

//        Deselect and assert checkboxes: Water, Wind
        driver.findElement(By.xpath("//*[@class='label-checkbox'][1]//input")).click();
        driver.findElement(By.xpath("//*[@class='label-checkbox'][3]//input")).click();
        assertFalse(driver.findElement(By.xpath("//*[@class='label-checkbox'][1]//input")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@class='label-checkbox'][3]//input")).isSelected());

//        Assert that for each checkbox there are
//        an individual log row and value
//        corresponds to the status of checkbox
        waterLogRow = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(text(), " +
                "'Water: condition changed to false')]"));
        windLogRow = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(text(), " +
                "'Wind: condition changed to false')]"));
        assertTrue(waterLogRow.isDisplayed());
        assertTrue(windLogRow.isDisplayed());
    }

}