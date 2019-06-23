package hw3.ex2;

import base.BaseTest;
import hw3.enums.TopMenu;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest {

    @Test
    public void differentElementsPageTest() {
//        Assert Browser title
        assertEquals(hp.getPageTitle(), "Home Page");

//        Click on "Service" subcategory in the header
//        and check that drop down contains options
        hp.clickTopMenu(TopMenu.SERVICE);
        List<String> providedServiceDropdownContents = Arrays
                .asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                        "TABLE WITH PAGES", "DIFFERENT ELEMENTS");

        assertTrue(hp.getServiceDropdownContents()
                .containsAll(providedServiceDropdownContents));

//        Open through the header menu
//        Service -> Different Elements Page
        hp.getDifferentElementsLink().click();
        assertEquals(dep.getDiffElementsPageUrl(), dep.DIFF_ELEMENTS_PAGE_LINK);

//        Check interface on Different elements page,
//        it contains all needed elements:
//        4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        assertEquals(dep.getCheckboxes().size(), 4);
        assertEquals(dep.getRadios().size(), 4);
        assertEquals(dep.getDropdowns().size(), 1);
        assertEquals(dep.getButtons().size(), 2);

//        Assert that there is Right Section
        assertTrue(dep.getRightSection().isDisplayed());

//        Assert that there is Left Section
        assertTrue(dep.getLeftSection().isDisplayed());

//        Select checkboxes: Water, Wind
        dep.getWaterCheckbox().click();
        dep.getWindCheckbox().click();
        dep.getWaterCheckbox().isSelected();
        dep.getWindCheckbox().isSelected();

//        Assert that for each checkbox there is an individual log row
//        and value corresponds to the status of checkbox.
        assertTrue(dep.getWaterLogRowTrue().isDisplayed());
        assertTrue(dep.getWindLogRowTrue().isDisplayed());

//        Select radio: Selen
        dep.getSelenCheckbox().click();

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        assertTrue(dep.getSelenLogRow().isDisplayed());

//        Select in dropdown: Yellow
        dep.getYellowDropdownOption().click();

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        assertTrue(dep.getColorLogRow().isDisplayed());

//        Deselect and assert checkboxes: Water, Wind
        dep.getWaterCheckbox().click();
        dep.getWindCheckbox().click();
        assertFalse(dep.getWaterCheckbox().isSelected());
        assertFalse(dep.getWindCheckbox().isSelected());

//        Assert that for each checkbox there are
//        an individual log row and value
//        corresponds to the status of checkbox
        assertTrue(dep.getWaterLogRowFalse().isDisplayed());
        assertTrue(dep.getWindLogRowFalse().isDisplayed());
    }

}