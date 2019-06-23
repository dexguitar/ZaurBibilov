package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DiffElementsPageSteps {

    private WebDriver driver;
    private HomePage hp;
    private DiffElementsPage dep;

    public DiffElementsPageSteps(WebDriver driver) {
        this.driver = driver;
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

    public void clickWaterCheckbox() {
        dep.getWaterCheckbox().click();
    }

    public void clickWindCheckbox() {
        dep.getWindCheckbox().click();
    }

    public void assertRightAndLeftSections() {
        assertTrue(dep.getRightSection().isDisplayed());
        assertTrue(dep.getLeftSection().isDisplayed());
    }

    public void checkSelen() {
        dep.getSelenCheckbox().click();
    }

    public void selectYellowinDropdown() {
        dep.getYellowDropdownOption().click();
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
        assertEquals(dep.getDiffElementsPageUrl(), dep.DIFF_ELEMENTS_PAGE_LINK);
    }

    public void selectCheckboxes() {
        clickElement(dep.getWaterCheckbox());
        clickElement(dep.getWindCheckbox());
        assertTrue(dep.getWaterCheckbox().isSelected());
        assertTrue(dep.getWindCheckbox().isSelected());
    }

    public void assertBoxesAndButtons() {
        assertEquals(dep.getCheckboxes().size(), 4);
        assertEquals(dep.getRadios().size(), 4);
        assertEquals(dep.getDropdowns().size(), 1);
        assertEquals(dep.getButtons().size(), 2);
    }

    public void assertWaterWindLogRowsTrue() {
        assertTrue(dep.getWaterLogRowTrue().isDisplayed());
        assertTrue(dep.getWindLogRowTrue().isDisplayed());
    }

    public void assertWaterWindLogRowsFalse() {
        clickWaterCheckbox();
        clickWindCheckbox();
        assertTrue(dep.getWaterLogRowFalse().isDisplayed());
        assertTrue(dep.getWindLogRowFalse().isDisplayed());
    }

    public void assertSelenRadioLogRow() {
        assertTrue(dep.getSelenLogRow().isDisplayed());
    }

    public void assertSelenLogRow() {
        assertTrue(dep.getSelenLogRow().isDisplayed());
    }

}