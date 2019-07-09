package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.ServiceDropdown;
import hw6.enums.TopMenu;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        // TODO I've seen this elements in the PageObject. Why do you decide use driver directly here?
        //  =>
        //  fixed || resolved
        homePage.clickElement(homePage.getUserIcon());
        homePage.getLoginNameTextField().sendKeys(username);
        homePage.getPasswordField().sendKeys(password);
        homePage.clickElement(homePage.getLoginButton());
    }

    @When("I click '(SERVICE|HOME)' header menu button")
    public void iClickHeaderMenuButton(TopMenu menuItem) {
        homePage.clickTopMenuElement(menuItem);
    }

    @When("I select '([^\"]*)' and '([^\"]*)' checkboxes")
    // TODO This is not good name for the method. Could I send another names of the checkboxes?
    //  =>
    //  fixed || resolved
    public void iSelectCheckboxesByLabels(String checkbox1, String checkbox2) {
        homePage.clickCheckbox(checkbox1);
        homePage.clickCheckbox(checkbox2);
    }

    @When("I select the '([^\"]*)' radio button")
    // TODO This is not good name for the method. Could I send another name of the radio button?
    //  =>
    //  fixed || resolved
    public void iSelectRadioButtonByLabel(String radioButtonLabel) {
        differentElementsPage.selectRadioButton(radioButtonLabel);
    }

    @When("I select '([^\"]*)' in the dropdown")
    // TODO This is not good name for the method. Could I send another name of item in the dropdown?
    //  =>
    //  fixed || resolved
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