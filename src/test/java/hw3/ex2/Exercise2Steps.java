package hw3.ex2;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import hw3.steps.DiffElementsPageSteps;

import static org.testng.Assert.*;

public class Exercise2Steps extends BaseTest {

    DiffElementsPageSteps diffElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        diffElementsPageSteps = new DiffElementsPageSteps(driver);
    }

    @Test
    public void diffElementsPageTest() {
//        Assert Browser title
        assertEquals(hp.getPageTitle(), "Home Page");

//        Perform login
        hp.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));

//        Assert User name in the left-top
//        side of screen that user is logged in
        assertEquals(hp.getTopRightUserName().toUpperCase(), "PITER CHAILOVSKII");

//        Click on "Service" subcategory in the header
//        and check that drop down contains options
        diffElementsPageSteps.clickServiceItem();
        hp.providedServiceDropdownElements.add("SUPPORT");
        hp.providedServiceDropdownElements.add("DATES");
        hp.providedServiceDropdownElements.add("COMPLEX TABLE");
        hp.providedServiceDropdownElements.add("SIMPLE TABLE");
        hp.providedServiceDropdownElements.add("TABLE WITH PAGES");
        hp.providedServiceDropdownElements.add("DIFFERENT ELEMENTS");
        assertTrue(hp.getServiceDropdownContents().containsAll(hp.providedServiceDropdownElements));

//        Open through the header menu
//        Service -> Different Elements Page
        diffElementsPageSteps.clickDifferentElementsLink();
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
        diffElementsPageSteps.clickWaterCheckbox();
        diffElementsPageSteps.clickWindCheckbox();
        dep.getWaterCheckbox().isSelected();
        dep.getWindCheckbox().isSelected();

//        Assert that for each checkbox there is
//        an individual log row and value
//        corresponds to the status of checkbox.
        assertTrue(dep.getWaterLogRowTrue().isDisplayed());
        assertTrue(dep.getWindLogRowTrue().isDisplayed());

//        Select radio: Selen
        diffElementsPageSteps.checkSelen();

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        assertTrue(dep.getSelenLogRow().isDisplayed());

//        Select in dropdown: Yellow
        diffElementsPageSteps.selectYellowinDropdown();

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        assertTrue(dep.getColorLogRow().isDisplayed());

//        Deselect and assert checkboxes: Water, Wind
        diffElementsPageSteps.clickWaterCheckbox();
        diffElementsPageSteps.clickWindCheckbox();
        assertFalse(dep.getWaterCheckbox().isSelected());
        assertFalse(dep.getWindCheckbox().isSelected());

//        Assert that for each checkbox there are
//        an individual log row and value
//        corresponds to the status of checkbox
        assertTrue(dep.getWaterLogRowFalse().isDisplayed());
        assertTrue(dep.getWindLogRowFalse().isDisplayed());
    }

}
