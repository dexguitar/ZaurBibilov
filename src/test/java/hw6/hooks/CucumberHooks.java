package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    WebDriver driver;
    HomePage homePage;
    DifferentElementsPage differentElementsPage;
    UserTablePage userTablePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        TestContext.setDriver(driver);
        homePage = HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage = UserTablePage.getInstance(TestContext.getDriver());
    }

    @After
    public void closeDriver() {
        HomePage.killObject(driver);
        DifferentElementsPage.killObject(driver);
        UserTablePage.killObject(driver);
        driver.quit();
    }

}