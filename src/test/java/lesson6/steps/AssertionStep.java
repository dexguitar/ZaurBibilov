package lesson6.steps;

import cucumber.api.java.en.Then;
import lesson6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername);
    }

    @Then("Dropdown list should be displayed")
    public void dropdownListShouldBeDisplayed() {
        assertTrue(TestContext.getDriver()
                .findElement(By.className("dropdown-menu")).isDisplayed());
    }

    @Then("Dropdown list should have '([^\"]*)' items")
    public void dropdownListShouldHaveItems(List<String> items) {
        List<WebElement> listSubMenu = TestContext.getDriver().
                findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
        List<String> subItemsText = listSubMenu.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(subItemsText, items);

    }

}