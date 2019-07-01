package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DiffElementsPageSteps extends BaseSteps {

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

    public void assertPageTitle(String title) {
        assertEquals(dep.getPageTitle(), title);
    }

    public void clickElement(WebElement link) {
        link.click();
    }

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

    public void assertServiceDropdown() {
        clickTopMenuItem(TopMenu.SERVICE);
        List<String> expectedServiceDropdownContents = Arrays
                .asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                        "TABLE WITH PAGES", "DIFFERENT ELEMENTS");

        assertTrue(hp.getServiceDropdownContents().containsAll(expectedServiceDropdownContents));
    }

    public void assertDiffElementsPageLink() {
        clickElement(hp.getDifferentElementsLink());
        assertEquals(dep.getDiffElementsPageUrl(), dep.getDiffElementsPageLink());
    }

    public void selectCheckbox(WebElement checkBox) {
        clickElement(checkBox);
    }

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

    public void assertSelenRadioLogRow() {
        assertTrue(dep.getSelenLogRow().isDisplayed());
    }

    public void assertColorLogRow(WebElement colorLogRow) {
        assertTrue(colorLogRow.isDisplayed());
    }

}