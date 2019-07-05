package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.ServiceDropdown;
import hw6.enums.TopMenu;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        TestContext.getDriver().findElement(By.id("user-icon")).click();
        TestContext.getDriver().findElement(By.id("name")).sendKeys(username);
        TestContext.getDriver().findElement(By.cssSelector("#password")).sendKeys(password);
        TestContext.getDriver().findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @When("I click '(SERVICE|HOME)' header menu button")
    public void iClickHeaderMenuButton(TopMenu menuItem) {
        homePage.clickTopMenuElement(menuItem);
    }

    @When("I select '([^\"]*)' and '([^\"]*)' checkboxes")
    public void iSelectWaterAndWindCheckboxes(String waterCheckbox, String windCheckbox) {
        homePage.clickCheckbox(waterCheckbox);
        homePage.clickCheckbox(windCheckbox);
    }

    @When("I select the '([^\"]*)' radio button")
    public void iSelectSelenRadioButton(String radioButtonName) {
        differentElementsPage.selectRadioButton(radioButtonName);
    }

    @When("I select '([^\"]*)' in the dropdown")
    public void iSelectYellowInDropdown(String option) {
        differentElementsPage.selectDropdownOption(option);
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