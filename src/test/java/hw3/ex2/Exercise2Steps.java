package hw3.ex2;

import base.BaseTest;
import hw3.steps.DiffElementsPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
<<<<<<< HEAD
//        and assert true for respective log rows
        diffElementsPageSteps.selectWaterWindCheckboxesAndAssertRespectiveLogRows();

//        Select radio: Selen
        diffElementsPageSteps.checkSelenRadio();
=======
        diffElementsPageSteps.selectCheckbox(dep.getWaterCheckbox());
        diffElementsPageSteps.selectCheckbox(dep.getWindCheckbox());

//        Assert that for each checkbox there is
//        an individual log row and value
//        corresponds to the status of checkbox.
        diffElementsPageSteps.assertLogRowTrue(dep.getWaterLogRowTrue());
        diffElementsPageSteps.assertLogRowTrue(dep.getWindLogRowTrue());

//        Select radio: Selen
        diffElementsPageSteps.checkRadio(dep.getSelenCheckbox());
>>>>>>> 99c9a6623a4662fd93b3ee13c4efb4e02d2cccca

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        diffElementsPageSteps.assertSelenRadioLogRow();

//        Select in dropdown: Yellow
<<<<<<< HEAD
        diffElementsPageSteps.selectYellowInDropdown();
=======
        diffElementsPageSteps.selectDropdownOption(dep.getYellowDropdownOption());
>>>>>>> 99c9a6623a4662fd93b3ee13c4efb4e02d2cccca

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        diffElementsPageSteps.assertColorLogRow(dep.getColorLogRow());

//        Deselect and assert checkboxes: Water, Wind
<<<<<<< HEAD
//        and assert respective log rows
        diffElementsPageSteps.deselectWaterWindCheckboxesAndAssertRespectiveLogRows();
=======
        diffElementsPageSteps.selectCheckbox(dep.getWaterCheckbox());
        diffElementsPageSteps.selectCheckbox(dep.getWindCheckbox());

//        Assert "Water" and "Wind" log rows
        diffElementsPageSteps.assertLogRowFalse(dep.getWaterLogRowFalse());
        diffElementsPageSteps.assertLogRowFalse(dep.getWindLogRowFalse());
>>>>>>> 99c9a6623a4662fd93b3ee13c4efb4e02d2cccca
    }

}