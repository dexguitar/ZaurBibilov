package hw3.steps;

import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void switchToIFrame() {
        driver.switchTo().frame("iframe");
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

}