package lesson6.steps;

import cucumber.api.java.en.When;
import lesson6.entities.User;
import lesson6.enums.HeaderMenu;
import lesson6.hooks.TestContext;
import org.openqa.selenium.By;

import java.util.List;

public class ActionSteps extends BaseSteps {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        TestContext.getDriver().findElement(By.id("user-icon")).click();
        TestContext.getDriver().findElement(By.id("name")).sendKeys(username);
        TestContext.getDriver().findElement(By.cssSelector("#password")).sendKeys(password);
        TestContext.getDriver().findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @When("I login as")
    public void iLoginAsEntity(List<User> users) {
        User user = users.get(0);
        System.out.println(users);
        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextField(user.getPassword());
        homePage.loginButtonClick();
    }

    @When("I click '(Home|Service)' header menu button")
    public void iClickHeaderMenuButton(HeaderMenu menuItem) {
        TestContext.getDriver()
                .findElement(By
                        .xpath("//ul[contains(@class, 'nav')]//a[contains(.,'"
                                + menuItem.getName() + "')]")).click();
    }

}