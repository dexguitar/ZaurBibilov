package hw3.ex2;

import base.BaseTest;
import hw3.steps.DiffElementsPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TODO Why this class needed?
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
        diffElementsPageSteps.assertPageTitle("Home Page");

//        Click on "Service" subcategory in the header
//        and check that drop down contains options
        diffElementsPageSteps.assertServiceDropdown();

//        Open through the header menu
//        Service -> Different Elements Page
        diffElementsPageSteps.assertDiffElementsPageLink();

//        Check interface on Different elements page,
//        it contains all needed elements:
//        4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        diffElementsPageSteps.assertBoxesAndButtons();

//        Assert that there is Right and Left sections
        diffElementsPageSteps.assertRightAndLeftSections();

//        Select checkboxes: Water, Wind
        // TODO May be it is better send
        //  checkbox name as parameter? => fixed || resolved
        diffElementsPageSteps.selectCheckbox(dep.getWaterCheckbox());
        diffElementsPageSteps.selectCheckbox(dep.getWindCheckbox());

//        Assert that for each checkbox there is
//        an individual log row and value
//        corresponds to the status of checkbox.
        // TODO May be it is better send
        //  checkbox name as parameter? => fixed || resolved
        diffElementsPageSteps.assertLogRowTrue(dep.getWaterLogRowTrue());
        diffElementsPageSteps.assertLogRowTrue(dep.getWindLogRowTrue());

//        Select radio: Selen
        // TODO May be it is better send
        //  radio button name as parameter? => fixed || resolved
        diffElementsPageSteps.checkRadio(dep.getSelenCheckbox());

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        diffElementsPageSteps.assertSelenRadioLogRow();

//        Select in dropdown: Yellow
        // TODO May be it is better send
        //  select name as parameter? => fixed || resolved
        diffElementsPageSteps.selectDropdownOption(dep.getYellowDropdownOption());

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        // TODO May be it is better send
        //  checkbox name as parameter? => fixed || resolved
        diffElementsPageSteps.assertColorLogRow(dep.getColorLogRow());

//        Deselect and assert checkboxes: Water, Wind
        diffElementsPageSteps.selectCheckbox(dep.getWaterCheckbox());
        diffElementsPageSteps.selectCheckbox(dep.getWindCheckbox());

//        Assert "Water" and "Wind" log rows
        // TODO May be it is better send
        //  checkbox name as parameter? => fixed || resolved
        diffElementsPageSteps.assertLogRowFalse(dep.getWaterLogRowFalse());
        diffElementsPageSteps.assertLogRowFalse(dep.getWindLogRowFalse());
    }

}