
package lesson6.steps;

import hw6.DifferentElementsPage;
import lesson6.HomePage;
import lesson6.hooks.TestContext;

public abstract class BaseStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public BaseStep() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
    }

}