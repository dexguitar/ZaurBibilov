package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.entities.User;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class AssertionSteps extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername);
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

    @Then("I navigate to the '([^\"]*)' page")
    public void iNavigateToPage(String pageTitle) {
        assertEquals(differentElementsPage.getPageTitle(), pageTitle);
    }

    @Then("'Different Elements' page contains (\\d) checkboxes, (\\d) radios, (\\d) dropdown and (\\d) buttons")
    public void differentElementsPageInterfaceIsCorrect(int checkboxes, int radios, int dropdowns, int buttons) {
        assertEquals(differentElementsPage.getCheckboxes().size(), checkboxes);
        assertEquals(differentElementsPage.getRadios().size(), radios);
        assertEquals(differentElementsPage.getDropDowns().size(), dropdowns);
        assertEquals(differentElementsPage.getButtons().size(), buttons);
    }

    @Then("There are the Right Section and the Left Section")
    public void thereAreLEftAndRightSections() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("'([^\"]*)' and '([^\"]*)' checkboxes are selected")
    public void waterAndWindCheckboxesAreSelected(String waterCheckbox, String windCheckbox) {
        assertTrue(differentElementsPage.getCheckbox(waterCheckbox).isSelected());
        assertTrue(differentElementsPage.getCheckbox(windCheckbox).isSelected());
    }

    @Then("'([^\"]*)' and '([^\"]*)' are present in true log rows")
    public void waterAndWindArePresentInTrueLogRows(String waterLogRow, String windLogRow) {
        assertTrue(differentElementsPage.findLogRow(waterLogRow, "true").isDisplayed());
        assertTrue(differentElementsPage.findLogRow(windLogRow, "true").isDisplayed());
    }

    @Then("'([^\"]*)' radio button is selected")
    public void selenCheckboxIsSelected(String radioButtonName) {
        assertTrue(differentElementsPage.getRadioButtonByName(radioButtonName).isSelected());
    }

    @Then("'([^\"]*)' is present in a metal log row")
    public void selenIsPresentInLogRow(String metal) {
        assertTrue(differentElementsPage.findMetalLogRow(metal).isDisplayed());
    }

    @Then("'([^\"]*)' is selected in the dropdown")
    public void yellowIsSelectedInDropdown(String option) {
        assertTrue(differentElementsPage.getDropdownOption(option).isSelected());
    }

    @Then("'([^\"]*)' is present in a color log row")
    public void yellowIsPresentInLogRow(String color) {
        assertTrue(differentElementsPage.findColorLogRow(color).isDisplayed());
    }

    @Then("'([^\"]*)' and '([^\"]*)' checkboxes are deselected")
    public void waterWindCheckboxesAreDeselected(String waterCheckbox, String windCheckbox) {
        assertTrue(!differentElementsPage.getCheckbox(waterCheckbox).isSelected());
        assertTrue(!differentElementsPage.getCheckbox(windCheckbox).isSelected());
    }

    @Then("'([^\"]*)' and '([^\"]*)' are present in false log rows")
    public void waterAndWindArePresentInFalseLogRows(String waterLogRow, String windLogRow) {
        assertTrue(differentElementsPage.findLogRow(waterLogRow, "false").isDisplayed());
        assertTrue(differentElementsPage.findLogRow(windLogRow, "false").isDisplayed());
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
//    @Then("Droplist for user '([^\\\"]*)' contains values:")
//    public void droplistContainsValues(String user, Droplist droplist) {
//        List<WebElement> dropdownElements = userTablePage.getDropdownContentsForUser(user);
//        for (WebElement element : dropdownElements) {
//            assertEquals(element.getText(), droplist.getValue());
//        }
//    }

}