package hw3.ex1;

import base.BaseTest;
import hw3.enums.TopMenu;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class Exercise1 extends BaseTest {

    // TODO What is this class for?
    @Test
    public void homePageContentTest() {
//        Assert Browser title
        assertEquals(hp.getPageTitle(), "Home Page");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> actualTopMenuElements = Stream.of(TopMenu.values())
                .map(el -> el.getName()).collect(Collectors.toList());
        List<String> expectedHeaderMenuText = Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS");

        assertEquals(hp.getMenuItems().size(), 4);
        assertEquals(actualTopMenuElements, expectedHeaderMenuText);

//        Assert that there are 4 images on the Index Page and they are displayed
        assertEquals(hp.getImages().size(), 4);

        SoftAssert sa = new SoftAssert();
        for (WebElement image: hp.getImages()) {
            sa.assertTrue(image.isDisplayed());
        }
        sa.assertAll();

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> textContents = hp.getTexts()
                .stream().map(el -> el.getText()).collect(Collectors.toList());
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

        assertEquals(hp.getTexts().size(), 4);
        assertEquals(textContents, expectedTextContents);
        for (WebElement text: hp.getTexts()) {
            sa.assertTrue(text.isDisplayed());
        }
        sa.assertAll();

//        Assert a text of the main headers
        assertTrue(hp.getMainTitle().isDisplayed());
        assertEquals(hp.getMainTitle().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(hp.getMainText().getText().contains("LABORIS NISI UT ALIQUIP EX " +
                "EA COMMODO CONSEQUAT DUIS AUTE"));

//        Assert that there is the iframe in the center of page
        assertTrue(hp.getiFrame().isDisplayed());

//        Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        checkEpamLogoInIframe();

//        Switch back to original window
        hp.switchToMainContent();

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

    private void checkEpamLogoInIframe() {
        hp.switchToIFrame();
        hp.getEpamLogo();
    }

}
