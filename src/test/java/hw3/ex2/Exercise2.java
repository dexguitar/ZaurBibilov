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
        checkOpenPageTitle("Home Page");

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
        clickElement(hp.getDifferentElementsLink());
        assertEquals(dep.getDiffElementsPageUrl(), dep.DIFF_ELEMENTS_PAGE_LINK);

//        Check interface on Different elements page,
//        it contains all needed elements:
//        4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        checkSize(dep.getCheckboxes(), 4);
        checkSize(dep.getRadios(), 4);
        checkSize(dep.getDropdowns(), 1);
        checkSize(dep.getButtons(), 2);

//        Assert that there is Right Section
        checkElementIsDisplayed(dep.getRightSection());

//        Assert that there is Left Section
        checkElementIsDisplayed(dep.getLeftSection());

//        Select checkboxes: Water, Wind
        clickElement(dep.getWaterCheckbox());
        clickElement(dep.getWindCheckbox());
        checkElementIsSelected(dep.getWaterCheckbox());
        checkElementIsSelected(dep.getWindCheckbox());

//        Assert that for each checkbox there is an individual log row
//        and value corresponds to the status of checkbox.
        checkElementIsDisplayed(dep.getWaterLogRowTrue());
        checkElementIsDisplayed(dep.getWindLogRowTrue());

//        Select radio: Selen
        clickElement(dep.getSelenCheckbox());

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        checkElementIsDisplayed(dep.getSelenLogRow());

//        Select in dropdown: Yellow
        clickElement(dep.getYellowDropdownOption());

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        checkElementIsDisplayed(dep.getColorLogRow());

//        Deselect and assert checkboxes: Water, Wind
        clickElement(dep.getWaterCheckbox());
        clickElement(dep.getWindCheckbox());
        checkElementIsDeSelected(dep.getWaterCheckbox());
        checkElementIsDeSelected(dep.getWindCheckbox());

//        Assert that for each checkbox there are
//        an individual log row and value
//        corresponds to the status of checkbox
        checkElementIsDisplayed(dep.getWaterLogRowFalse());
        checkElementIsDisplayed(dep.getWindLogRowFalse());
    }

}