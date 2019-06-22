package hw3.ex1;

import base.BaseTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import hw3.steps.HomePageSteps;
import hw3.enums.TopMenu;
import hw3.voids.HomePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1Steps extends BaseTest {

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void homePageTest() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);

//        Assert The Browser title
        assertEquals(hp.getPageTitle(), "Home Page");

//        Perform login
        hp.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));

//        Assert User name in the top-right corner of screen that user is logged in
        assertEquals(hp.getTopRightUserName(), "PITER CHAILOVSKII");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(hp.getMenuItems().size(), 4);
        assertEquals(hp.getMenuItems().get(0).getText(), TopMenu.HOME.getName());
        assertEquals(hp.getMenuItems().get(1).getText(), TopMenu.CONTACT_FORM.getName());
        assertEquals(hp.getMenuItems().get(2).getText(), TopMenu.SERVICE.getName());
        assertEquals(hp.getMenuItems().get(3).getText(), TopMenu.METALS_AND_COLORS.getName());

//        Assert that there are 4 images on the Index Page and they are displayed
        assertEquals(hp.getImages().size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(hp.getImages().get(i).isDisplayed());
        }

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(hp.getTexts().size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(hp.getTexts().get(i).isDisplayed());
        }
        assertTrue(hp.getTexts().get(0).getText().contains("include good practices\n" +
                "and ideas from successful"));
        assertTrue(hp.getTexts().get(1).getText().contains("be flexible and\n" +
                "customizable"));
        assertTrue(hp.getTexts().get(2).getText().contains("be multiplatform"));
        assertTrue(hp.getTexts().get(3).getText().contains("about 20 internal and\n" +
                "some external projects"));

//        Assert a text of the main headers
        assertTrue(hp.getMainTitle().isDisplayed());
        assertEquals(hp.getMainTitle().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(hp.getMainText().getText().contains("LABORIS NISI UT ALIQUIP EX " +
                "EA COMMODO CONSEQUAT DUIS AUTE"));

//        Assert that there is the iframe in the center of page
        assertTrue(hp.getiFrame().isDisplayed());

//        Switch to the iframe and check that there is
//        Epam logo in the left top corner of iframe
        homePageSteps.switchToIFrame();
        assertTrue(hp.checkEpamLogo().isDisplayed());

//        Switch back to original window
        homePageSteps.switchToMainContent();

        //        Assert a text of the sub header
        assertEquals(hp.getSubHeader().getText(), "JDI GITHUB");

//        Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(hp.getJdiLink().isDisplayed());
        assertEquals(hp.getJdiLink().getAttribute("href"), hp.JDI_LINK_URL);

//        Assert that there is Left Section
        assertTrue(hp.getLeftSection().isDisplayed());

//        Assert that there is Footer
        assertTrue(hp.getFooter().isDisplayed());
    }

}