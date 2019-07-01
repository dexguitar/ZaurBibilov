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
//        and assert true for respective log rows
        diffElementsPageSteps.selectWaterWindCheckboxesAndAssertRespectiveLogRows();

//        Select radio: Selen
        diffElementsPageSteps.checkSelenRadio();

//      Assert that for radiobutton there is a log row
//      and value corresponds to the status of radiobutton.
        diffElementsPageSteps.assertSelenRadioLogRow();

//        Select in dropdown: Yellow
        diffElementsPageSteps.selectYellowInDropdown();

//        Assert that for dropdown there is a log row and value
//        corresponds to the selected value.
        diffElementsPageSteps.assertColorLogRow(dep.getColorLogRow());

//        Deselect checkboxes: Water, Wind
//        and assert respective log rows
        diffElementsPageSteps.deselectWaterWindCheckboxesAndAssertRespectiveLogRows();
    }

}