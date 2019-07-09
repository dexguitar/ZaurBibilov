package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.entities.User;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class AssertionSteps extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
        // TODO I think this information exist in the page object
        //  =>
        //  fixed || resolved
        assertEquals(homePage.getUsernameField().getText(), expectedUsername);
    }

    @Then("There are (\\d) pictures, (\\d) texts under them, a headline and a description")
    public void assertPicturesTextsHeadlineAndDescription(int imagesNumber, int textsNumber) {
        assertEquals(homePage.getImages().size(), imagesNumber);
        assertEquals(homePage.getTexts().size(), textsNumber);
        assertTrue(homePage.getMainTitle().isDisplayed());
        assertTrue(homePage.getDescription().isDisplayed());
    }

    @Then("Dropdown should contain the following items: '([^\"]*)'")
    public void dropdownListShouldContainItems(List<String> items) {
        List<WebElement> submenu = homePage.getServiceDropdown();
        List<String> subItemsText = submenu.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String item: items) {
            assertTrue(subItemsText.contains(item.toUpperCase()));
        }
    }

    // TODO Why this step is here? The name of the step def sounds like that I should go to the page
    //  =>
    //  fixed || resolved
//    @Then("I navigate to the '([^\"]*)' page")
//    public void iNavigateToPage(String pageTitle) {
//        assertEquals(differentElementsPage.getPageTitle(), pageTitle);
//    }

    @Then("'Different Elements' page contains (\\d) checkboxes, (\\d) radios, (\\d) dropdown and (\\d) buttons")
    public void differentElementsPageInterfaceIsCorrect(int checkboxes, int radios, int dropdowns, int buttons) {
        assertEquals(differentElementsPage.getCheckboxes().size(), checkboxes);
        assertEquals(differentElementsPage.getRadios().size(), radios);
        assertEquals(differentElementsPage.getDropDowns().size(), dropdowns);
        assertEquals(differentElementsPage.getButtons().size(), buttons);
    }

    @Then("There is the Right Section")
    // TODO It is better split this assertion to the 2 => fixed || resolved
    public void thereIsRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("There is the Left Section")
    public void thereIsLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("'([^\"]*)' and '([^\"]*)' checkboxes are selected")
    // TODO Could I verify another checkboxes? => fixed || resolved
    public void CheckboxesAreSelected(String checkbox1, String checkbox2) {
        assertTrue(differentElementsPage.getCheckbox(checkbox1).isSelected());
        assertTrue(differentElementsPage.getCheckbox(checkbox2).isSelected());
    }

    @Then("'([^\"]*)' and '([^\"]*)' are present in the log as '([^\"]*)'")
    // TODO Could I verify another checkboxes? => fixed || resolved
    public void valuesArePresentInTrueLogRows(String value1, String value2, String boolValue) {
        assertTrue(differentElementsPage.findLogRow(value1, boolValue).isDisplayed());
        assertTrue(differentElementsPage.findLogRow(value2, boolValue).isDisplayed());
    }

    @Then("'([^\"]*)' radio button is selected")
    // TODO Could I verify another radio button? => fixed || resolved
    public void radioButtonIsSelected(String radioButtonLabel) {
        assertTrue(differentElementsPage.getRadioButtonByName(radioButtonLabel).isSelected());
    }

    @Then("'([^\"]*)' is present in the 'Metals: ' log row")
    // TODO Could I verify another radio button? => fixed || resolved
    public void metalIsPresentInLogRow(String metal) {
        assertTrue(differentElementsPage.findMetalLogRow(metal).isDisplayed());
    }

    @Then("'([^\"]*)' is selected in the dropdown")
    // TODO Could I verify another value in the dropdown list? => fixed || resolved
    public void colorIsSelectedInDropdown(String option) {
        assertTrue(differentElementsPage.getDropdownOption(option).isSelected());
    }

    @Then("'([^\"]*)' is present in the 'Colors: ' log row")
    // TODO Could I verify another value in the dropdown list? => fixed || resolved
    public void colorIsPresentInLogRow(String color) {
        assertTrue(differentElementsPage.findColorLogRow(color).isDisplayed());
    }

    @Then("'([^\"]*)' and '([^\"]*)' checkboxes are deselected")
    // TODO Could I verify another checkboxes? => fixed || resolved
    public void checkboxesAreDeselected(String checkbox1, String checkbox2) {
        assertTrue(!differentElementsPage.getCheckbox(checkbox1).isSelected());
        assertTrue(!differentElementsPage.getCheckbox(checkbox2).isSelected());
    }

//    @Then("'([^\"]*)' and '([^\"]*)' are present in false log rows")
//    // TODO Could I verify another checkboxes? => fixed || resolved
//    public void valuesArePresentInFalseLogRows(String value1, String value2) {
//        assertTrue(differentElementsPage.findLogRow(value1, "false").isDisplayed());
//        assertTrue(differentElementsPage.findLogRow(value2, "false").isDisplayed());
//    }

    @Then("There are (\\d) dropdowns, usernames, images, texts and checkboxes displayed")
    public void thereAreNElementsDisplayed(int number) {
        assertEquals(userTablePage.getNumberDropdowns().size(), number);
        assertEquals(userTablePage.getUserNames().size(), number);
        assertEquals(userTablePage.getImages().size(), number);
        assertEquals(userTablePage.getTextDescriptions().size(), number);
        assertEquals(userTablePage.getCheckboxes().size(), number);
    }

    @Then("User Table contains following values:")
    public void userTableContainsValues(List<User> users) {
        for (User user: users) {
            assertEquals(userTablePage.getUsernumber(user.getUserNumber()), user.getUserNumber());
            assertEquals(userTablePage.getUsername(user.getUserName()), user.getUserName());
            assertTrue(userTablePage.getDescription(user.getUserDescription()).contains(user.getUserDescription()));
        }
    }

    @Then("Log row has '([^\"]*)' text in log section")
    public void logRowHasConditionTrueLogMessage(String value) {
        assertTrue(userTablePage.getLogRow(value).isDisplayed());
    }

    @Then("Droplist for user '([^\"]*)' contains values: '([^\"]*)'")
    public void droplistContainsValues(String user, List<String> expectedContents) {
        List<String> dropdown = userTablePage.getDropdownContentsForUser(user)
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(dropdown.containsAll(expectedContents));
    }

}