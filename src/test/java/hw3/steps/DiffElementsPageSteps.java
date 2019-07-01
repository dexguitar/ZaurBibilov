package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DiffElementsPageSteps extends BaseSteps {

    // TODO Could be extratced to the base class => fixed || resolved
    private HomePage hp;
    private DiffElementsPage dep;

    public DiffElementsPageSteps(WebDriver driver) {
        super(driver);
        dep = new DiffElementsPage(driver);
        hp = new HomePage(driver);
    }

    public void clickTopMenuItem(TopMenu item) {
        dep.clickTopMenu(item);
    }

    @Step("Assert Browser title")
    public void assertPageTitle(String title) {
        assertEquals(dep.getPageTitle(), title);
    }

    public void clickElement(WebElement link) {
        link.click();
    }

    @Step("Assert that there is Right and Left sections")
    public void assertRightAndLeftSections() {
        assertTrue(dep.getRightSection().isDisplayed());
        assertTrue(dep.getLeftSection().isDisplayed());
    }

    public void checkRadio(WebElement radioButton) {
        radioButton.click();
    }

    public void selectDropdownOption(WebElement dropdownOption) {
        dropdownOption.click();
    }

    @Step("Select in dropdown: 'Yellow'")
    public void selectYellowInDropdown() {
        selectDropdownOption(dep.getYellowDropdownOption());
    }

    @Step("Click on 'Service' subcategory in the header and check that drop down contains options")
    public void assertServiceDropdown() {
        clickTopMenuItem(TopMenu.SERVICE);
        List<String> expectedServiceDropdownContents = Arrays
                .asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                        "TABLE WITH PAGES", "DIFFERENT ELEMENTS");

        assertTrue(hp.getServiceDropdownContents().containsAll(expectedServiceDropdownContents));
    }

    @Step("Open through the header menu: 'Service' -> 'Different Elements Page'")
    public void assertDiffElementsPageLink() {
        clickElement(hp.getDifferentElementsLink());
        assertEquals(dep.getDiffElementsPageUrl(), dep.getDiffElementsPageLink());
    }

    public void selectCheckbox(WebElement checkBox) {
        clickElement(checkBox);
    }

    @Step("Select checkboxes: Water, Wind and assert respective log rows")
    public void selectWaterWindCheckboxesAndAssertRespectiveLogRows() {
        selectCheckbox(dep.getWaterCheckbox());
        selectCheckbox(dep.getWindCheckbox());
        assertLogRowTrue(dep.getWaterLogRowTrue());
        assertLogRowTrue(dep.getWindLogRowTrue());
    }

    @Step("Deselect checkboxes: Water, Wind and assert respective log rows")
    public void deselectWaterWindCheckboxesAndAssertRespectiveLogRows() {
        selectCheckbox(dep.getWaterCheckbox());
        selectCheckbox(dep.getWindCheckbox());
        assertLogRowFalse(dep.getWaterLogRowFalse());
        assertLogRowFalse(dep.getWindLogRowFalse());
    }

    @Step("Check interface on Different elements page," +
            "it contains all needed elements:" +
            "4 checkboxes, 4 radios, 1 dropdown, 2 buttons")
    public void assertBoxesAndButtons() {
        assertEquals(dep.getCheckboxes().size(), 4);
        assertEquals(dep.getRadios().size(), 4);
        assertEquals(dep.getDropdowns().size(), 1);
        assertEquals(dep.getButtons().size(), 2);
    }

    public void assertLogRowTrue(WebElement logRowTrue) {
        assertTrue(logRowTrue.isDisplayed());
    }

    public void assertLogRowFalse(WebElement logRowFalse) {
        assertTrue(logRowFalse.isDisplayed());
    }

    @Step("Assert Selen Radio Log Row")
    public void assertSelenRadioLogRow() {
        assertTrue(dep.getSelenLogRow().isDisplayed());
    }

    @Step("Assert color log row")
    public void assertColorLogRow(WebElement colorLogRow) {
        assertTrue(colorLogRow.isDisplayed());
    }

    @Step("Select radio: Selen")
    public void checkSelenRadio() {
        checkRadio(dep.getSelenCheckbox());
    }

}