package lesson4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import lesson3.enums.LeftSideMenu;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Example1 {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.FIREFOX;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "target/selenide/reports/test";
    }

    @Test
    public void loginTest() {
        open("https://epam.github.io/JDI");

        $(By.id("user-icon")).click();
        $(By.id("name")).sendKeys("epam");
        $("#password").sendKeys("1234");
        $(By.xpath("//button[@id='login-button']")).click();

        $("#user-name").shouldHave(text("PITER CHAILOVSKII1"));

        // How to get Selenium WebDriver
//        WebElement wrappedElement = $("").getWrappedElement();
//        new Actions(getWebDriver()).dragAndDrop(wrappedElement, wrappedElement);
    }

    @Test
    public void contactPageTest() {
        HomePage hp = open("https://epam.github.io/JDI", HomePage.class);
        hp.login("epam", "1234");

        hp.clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
        ContactFormPage cfp = new ContactFormPage();
        cfp.setTextLastNameTextField("Last Name");
        cfp.selectGender("Female");

        cfp.getGenderDropdownValue().shouldHave(text("Female"));
    }
}