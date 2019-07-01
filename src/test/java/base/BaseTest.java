package base;

import hw3.utils.FileUtils;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lesson5.TestProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage hp;
    protected DiffElementsPage dep;
    protected Properties userInfo;

    @BeforeSuite
    public void initialSetUp() {
//        System.setProperty("webdriver.chrome.driver",
//                Paths.get("src/test/resources/driver/chromedriver")
//                        .toAbsolutePath().toString());
        WebDriverManager.chromedriver().setup();
        userInfo = FileUtils.readUserFromFile
                ("src/test/resources/properties/user.properties");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestProvider.getInstance().setDriver(driver);
        driver.get("https://epam.github.io/JDI");
        hp = PageFactory.initElements(driver, HomePage.class);
        dep = PageFactory.initElements(driver, DiffElementsPage.class);
        login("epam", "1234");
    }

    protected void login(String login, String password) {
//        Open test site by URL
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

//        Assert The Browser title
        checkOpenPageTitle("Home Page");

//        Perform login
        WebElement userIcon = driver.findElement(By.id("user-icon"));
        userIcon.click();
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(login);
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

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

    protected void checkElementIsDeSelected(WebElement element) {
        assertFalse(element.isSelected());
    }

    protected void checkSizeAndContains(List<WebElement> container, List<String> contained,
                                        int size) {
        List<String> actualContents = container.stream()
                .map(WebElement::getText).collect(Collectors.toList());

        assertEquals(container.size(), size);
        assertEquals(actualContents, contained);
    }

    protected void checkText(WebElement element, String text) {
        assertEquals(element.getText(), text);
    }

    protected void checkTextContains(WebElement element, String text) {
        assertTrue(element.getText().contains(text));
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected WebElement findCheckbox(String artifact) {
        return driver.findElement(By.xpath("//*[@class='label-checkbox' and contains(., '"
                + artifact + "')]//input"));
    }

    protected WebElement findRadioButton(String artifact) {
        return driver.findElement(By.xpath("//*[@class='label-radio' " +
                "and contains(., '" + artifact + "')]//input"));
    }

    protected WebElement findOption(String artifact) {
        return driver.findElement(By.xpath("//option[contains(text(), '"
                + artifact + "')]"));
    }

    protected WebElement findLogRow(String artifact, String value) {
        return driver.findElement(By.xpath("//li[contains(text(), '" + artifact + "') " +
                "and contains(text(), '" + value + "')]"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}