package hw5;

import base.BaseTest;
import hw3.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson5.AllureAttachmentListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Listeners(AllureAttachmentListener.class)
@Feature("Epam site test")
@Story(value = "Home Page Failed Test")
public class FailedTest extends BaseTest {

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test(testName = "Failed test")
    public void homePageTest() {
//        Assert page title
        homePageSteps.assertPageTitle("Home Page");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedHeaderItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        homePageSteps.assertHeaderSectionItems(expectedHeaderItems, 3);

//        Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = hp.getImages();
        homePageSteps.assertPageElements(images, 4);

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> textContents = hp.getTexts()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedContents = Arrays.asList(
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

        homePageSteps.assertTexts(textContents, expectedContents);

//        Assert a text of the main headers
        homePageSteps.assertMainHeadersText();

//        Assert that there is the iframe in the center of page
        homePageSteps.assertIsDisplayed(hp.getiFrame());

//        Switch to the iframe and check that there is
//        Epam logo in the left top corner of iframe
        homePageSteps.switchToIFrameAndCheckLogo();

//        Switch back to original window
        homePageSteps.switchToMainContent();

//        Assert a text of the sub header
        homePageSteps.assertSubHeaderText();

//        Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.assertJDIisLinkAndHasProperURL();

//        Assert that there is Left Section
        homePageSteps.assertLeftSection();

//        Assert that there is Footer
        homePageSteps.assertFooter();
    }

}