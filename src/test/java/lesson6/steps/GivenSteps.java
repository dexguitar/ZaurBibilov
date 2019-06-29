package lesson6.steps;

import cucumber.api.java.en.Given;
import lesson6.hooks.TestContext;

public class GivenSteps extends BaseSteps {

    @Given("I am on the JDI Index page")
    public void iAmOnTheJDIIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

}
