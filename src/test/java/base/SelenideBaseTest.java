package base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import hw3.utils.FileUtils;
import hw4.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class SelenideBaseTest {

    protected Properties userInfo;
    protected HomePage homePage;

    @BeforeSuite
    public void initialSetUp() {
        WebDriverManager.chromedriver().setup();
        userInfo = FileUtils.readUserFromFile
                ("src/test/resources/properties/user.properties");
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "target/selenide/reports/test";

//        Open test site by URL
        homePage = open("https://epam.github.io/JDI/index.html", HomePage.class);
        login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
    }

    protected void login(String login, String password) {
//        Assert browser title
        $("title").shouldHave(attribute("text", "Home Page"));

//        Perform login
        $("#user-icon").click();
        $("#name").sendKeys(login);
        $("#password").sendKeys(password);
        $(By.xpath("//button[@id='login-button']")).click();

//        Assert User name in the top-right corner of the screen
        $("#user-name").shouldBe(Condition.text("PITER CHAILOVSKII"));
    }

    @AfterMethod
    public void tearDown() {
        close();
    }

}
