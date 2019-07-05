package lesson6.steps;

import cucumber.api.java.en.When;
import lesson6.hooks.TestContext;
import org.openqa.selenium.By;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        TestContext.getDriver().findElement(By.id("user-icon")).click();
        TestContext.getDriver().findElement(By.id("name")).sendKeys(username);
        TestContext.getDriver().findElement(By.cssSelector("#password")).sendKeys(password);
        TestContext.getDriver().findElement(By.xpath("//button[@id='login-button']")).click();
    }



}
