package hw2.ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest {

    @Test
    public void differentElementsPageTest() {

//        Assert Browser title
        checkOpenPageTitle("Home Page");

//        Click on "Service" subcategory in the header
//        and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]")).click();
        List<WebElement> actualDropdownElements = driver.findElements(By.xpath("//*[@class='dropdown open'" +
                "]//ul[@class='dropdown-menu']//li"));
        // TODO Why do you not use checkSizeAndContains from BaseTest? fixed || resolved
        // checkSizeAndContains() checks for full match and doesn't fit here
        List<String> dropDownContents = actualDropdownElements
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedElements = Arrays
                .asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                        "TABLE WITH PAGES", "DIFFERENT ELEMENTS");

        assertTrue(dropDownContents.containsAll(expectedElements));

//        Open through the header menu
//        Service -> Different Elements Page
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(), 'Different elements')]")).click();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");

//        Check interface on Different elements page,
//        it contains all needed elements:
//        4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        assertEquals(checkboxes.size(), 4);
        List<WebElement> radios = driver.findElements(By.xpath("//*[@type='radio']"));
        assertEquals(radios.size(), 4);
        List<WebElement> dropdowns = driver.findElements(By.xpath("//select"));
        assertEquals(dropdowns.size(), 1);
        List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(@value, 'Button')]"));
        assertEquals(buttons.size(), 2);

//        Assert that there is Right Section
        checkElementIsDisplayed(driver.findElement(By.xpath("//*[@class='uui-side-bar right-fix-panel mCustomScrollbar" +
                " _mCS_2 mCS_no_scrollbar']")));

//        Assert that there is Left Section
        checkElementIsDisplayed(driver.findElement(By.xpath("//*[@class='sidebar-menu']")));

//        Select checkboxes: Water, Wind
        findCheckbox("Water").click();
        findCheckbox("Wind").click();
        checkElementIsSelected(findCheckbox("Water"));
        checkElementIsSelected(findCheckbox("Wind"));

//        Assert that for each checkbox there is an individual log row
//        and value corresponds to the status of checkbox.
        WebElement waterLogRow = findLogRow("Water", "true");
        checkElementIsDisplayed(waterLogRow);
        WebElement windLogRow = findLogRow("Wind", "true");
        checkElementIsDisplayed(windLogRow);

//        Select radio: Selen
        findRadioButton("Selen").click();

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        WebElement selenLogRow = findLogRow("metal", "Selen");
        checkElementIsDisplayed(selenLogRow);

//        Select in dropdown: Yellow
        findOption("Yellow").click();

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        WebElement colorLogRow = findLogRow("Colors", "Yellow");
        checkElementIsDisplayed(colorLogRow);

//        Deselect and assert checkboxes: Water, Wind
        findCheckbox("Water").click();
        findCheckbox("Wind").click();
        checkElementIsDeSelected(findCheckbox("Water"));
        checkElementIsDeSelected(findCheckbox("Wind"));

//        Assert that for each checkbox there are
//        an individual log row and value
//        corresponds to the status of checkbox
        waterLogRow = findLogRow("Water", "false");
        windLogRow = findLogRow("Wind", "false");
        checkElementIsDisplayed(waterLogRow);
        checkElementIsDisplayed(windLogRow);
    }

}