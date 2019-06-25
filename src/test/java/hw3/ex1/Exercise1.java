package hw3.ex1;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise1 extends BaseTest {

    @Test
    public void homePageContentTest() {
//        Assert Browser title
        checkOpenPageTitle("Home Page");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedHeaderMenuText = Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS");

        checkSizeAndContains(hp.getMenuItems(), expectedHeaderMenuText, 4);

//        Assert that there are 4 images on the Index Page and they are displayed
        checkSize(hp.getImages(), 4);

        SoftAssert sa = new SoftAssert();
        for (WebElement image: hp.getImages()) {
            sa.assertTrue(image.isDisplayed());
        }
        sa.assertAll();

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedTextContents = Arrays.asList(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"
        );

        checkSizeAndContains(hp.getTexts(), expectedTextContents, 4);
        for (WebElement text: hp.getTexts()) {
            sa.assertTrue(text.isDisplayed());
        }
        sa.assertAll();

//        Assert a text of the main headers
        checkElementIsDisplayed(hp.getiFrame());
        checkText(hp.getMainTitle(), "EPAM FRAMEWORK WISHES…");
        checkTextContains(hp.getMainText(), "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE");

//        Assert that there is the iframe in the center of page
        checkElementIsDisplayed(hp.getiFrame());

//        Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        hp.switchToIFrame();
        checkElementIsDisplayed(hp.getEpamLogo());

//        Switch back to original window
        hp.switchToMainContent();

//        Assert a text of the sub header
        checkText(hp.getSubHeader(), "JDI GITHUB");

//        Assert that JDI GITHUB is a link and has a proper URL
        checkElementIsDisplayed(hp.getJdiLink());
        assertEquals(hp.getJdiLink().getAttribute("href"), hp.JDI_LINK_URL);

//        Assert that there is Left Section
        checkElementIsDisplayed(hp.getLeftSection());

//        Assert that there is Footer
        checkElementIsDisplayed(hp.getFooter());
    }

}
