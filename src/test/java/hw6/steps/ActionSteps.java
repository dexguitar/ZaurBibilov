package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.ServiceDropdown;
import hw6.enums.TopMenu;

import java.util.List;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        homePage.clickElement(homePage.getUserIcon());
        homePage.getLoginNameTextField().sendKeys(username);
        homePage.getPasswordField().sendKeys(password);
        homePage.clickElement(homePage.getLoginButton());
    }

    @When("I click '(SERVICE|HOME)' header menu button")
    public void iClickHeaderMenuButton(TopMenu menuItem) {
        homePage.clickTopMenuElement(menuItem);
    }

    @When("I select checkboxes: '([^\"]*)' at the top of the main content section")
    public void iSelectCheckboxesByLabel(List<String> labels) {
        homePage.clickCheckbox(labels);
    }

    @When("I select the '([^\"]*)' radio button")
    public void iSelectRadioButtonByLabel(String radioButtonLabel) {
        differentElementsPage.selectRadioButton(radioButtonLabel);
    }

    @When("I select '([^\"]*)' in the dropdown")
    public void iSelectDropdownOptionByValue(String optionValue) {
        differentElementsPage.selectDropdownOption(optionValue);
    }

    @When("I deselect '([^\"]*)' and '([^\"]*)' checkboxes")
    public void iDeselectWaterWindCheckboxes(String waterCheckbox, String windCheckbox) {
        differentElementsPage.getCheckbox(waterCheckbox).click();
        differentElementsPage.getCheckbox(windCheckbox).click();
    }

    @When("I click '(DIFFERENT_ELEMENTS|USER_TABLE)' in the 'Service' dropdown")
    public void iClickElement(ServiceDropdown item) {
        homePage.clickServiceDropdownItem(item);
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void iSelectVipBoxForUser(String username) {
        userTablePage.clickCheckbox(username);
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void iClickDropdownForUserN(String user) {
        userTablePage.clickDropdownForUser(user);
    }

}