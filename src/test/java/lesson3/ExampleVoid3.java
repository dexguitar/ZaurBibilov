package lesson3;

import base.BaseTest;
import lesson3.enums.LeftSideMenu;
import lesson3.voids.ContactFormPage;
import lesson3.voids.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleVoid3 extends BaseTest {

    @Test
    public void seleniumOpenPageTest() {
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.linkText("Metals & Colors")).click();
    }

    @Test
    public void loginTest() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.login("epam", "1234");

        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }

    @Test
    public void contactPageTest() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.login("epam", "1234");

        ContactFormPage cfp = new ContactFormPage(driver);
        cfp.clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
        cfp.setTextLastNameTextField("Last Name");
        cfp.selectGender("Female");

        assertEquals(cfp.getGenderDropdownValue(), "Female");
    }

}