package base;

import hw3.utils.FileUtils;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage hp;
    protected DiffElementsPage dep;
    protected Properties userInfo;

    @BeforeSuite
    public void initialSetUp() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver")
                        .toAbsolutePath().toString());
        userInfo = FileUtils.readUserFromFile("src/test/resources/properties/user.properties");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI");
        hp = PageFactory.initElements(driver, HomePage.class);
        dep = PageFactory.initElements(driver, DiffElementsPage.class);
        loginTest("epam", "1234");
    }

    protected void loginTest(String login, String password) {
//        Open test site by URL
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

//        Assert The Browser title
        assertEquals(driver.getTitle(), "Home Page");

//        Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys(login);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

//        Assert User name in the left-top side of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }

    protected void checkOpenPageTitle(String pageTitle) {
        //        Assert Browser title
        assertEquals(driver.getTitle(), pageTitle);
    }

    protected void checkElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    protected void checkElementIsSelected(WebElement element) {
        assertTrue(element.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}