package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.entities.User;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class AssertionSteps extends BaseStep {

    @Then("I am on the '([^\"]*)' page")
    public void iAmOnThePageN(String pageTitle) {
        assertEquals(userTablePage.getPageTitle(), pageTitle);
    }

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
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

    @Then("'Different Elements' page contains (\\d) checkboxes, (\\d) radios, (\\d) dropdown and (\\d) buttons")
    public void differentElementsPageInterfaceIsCorrect(int checkboxes, int radios, int dropdowns, int buttons) {
        assertEquals(differentElementsPage.getCheckboxes().size(), checkboxes);
        assertEquals(differentElementsPage.getRadios().size(), radios);
        assertEquals(differentElementsPage.getDropDowns().size(), dropdowns);
        assertEquals(differentElementsPage.getButtons().size(), buttons);
    }

    @Then("There is the Right Section")
    public void thereIsRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("There is the Left Section")
    public void thereIsLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("Checkboxes are selected: '([^\"]*)'")
    public void CheckboxesAreSelected(List<String> checkBoxes) {
        for (String checkbox : checkBoxes) {
            assertTrue(differentElementsPage.getCheckbox(checkbox).isSelected());
        }
    }

    @Then("'([^\"]*)' and '([^\"]*)' are present in the log as '([^\"]*)'")
    public void valuesArePresentInTrueLogRows(String value1, String value2, String boolValue) {
        assertTrue(differentElementsPage.findLogRow(value1, boolValue).isDisplayed());
        assertTrue(differentElementsPage.findLogRow(value2, boolValue).isDisplayed());
    }

    @Then("'([^\"]*)' radio button is selected")
    public void radioButtonIsSelected(String radioButtonLabel) {
        assertTrue(differentElementsPage.getRadioButtonByName(radioButtonLabel).isSelected());
    }

    @Then("'([^\"]*)' is present in the 'Metals: ' log row")
    public void metalIsPresentInLogRow(String metal) {
        assertTrue(differentElementsPage.findMetalLogRow(metal).isDisplayed());
    }

    @Then("'([^\"]*)' is selected in the dropdown")
    public void colorIsSelectedInDropdown(String option) {
        assertTrue(differentElementsPage.getDropdownOption(option).isSelected());
    }

    @Then("'([^\"]*)' is present in the 'Colors: ' log row")
    public void colorIsPresentInLogRow(String color) {
        assertTrue(differentElementsPage.findColorLogRow(color).isDisplayed());
    }

    @Then("Checkboxes are deselected: '([^\"]*)'")
    public void checkboxesAreDeselected(List<String> checkBoxes) {
        for (String checkbox : checkBoxes) {
            assertFalse(differentElementsPage.getCheckbox(checkbox).isSelected());
        }
    }


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