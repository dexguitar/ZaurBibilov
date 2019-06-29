package lesson6.steps;

import lesson6.HomePage;
import lesson6.hooks.TestContext;

public abstract class BaseSteps {

    protected HomePage homePage;

    public BaseSteps() {
        homePage = HomePage.getInstance(TestContext.getDriver());
    }

}