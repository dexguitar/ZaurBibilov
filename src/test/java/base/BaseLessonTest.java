package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseLessonTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getClassLoader().getResource("driver/chromedriver").getPath());
//        System.setProperty("webdriver.chrome.driver",
//                Paths.get("src/test/resources/driver/chromedriver")
//                        .toAbsolutePath().toString());
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}