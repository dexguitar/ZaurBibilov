package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class HomePageSteps extends BaseSteps {

    // TODO Could be extratced to the base class => fixed || resolved
    private HomePage hp;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        hp = new HomePage(driver);
    }

    @Step("Assert that there is Left Section")
    public void assertLeftSection() {
        WebElement leftSection = hp.getLeftSection();
        assertIsDisplayed(leftSection);
    }

    @Step("Assert that there is Footer")
    public void assertFooter() {
        WebElement footer = hp.getFooter();
        assertIsDisplayed(footer);
    }

    @Step("Assert that JDI GITHUB is a link and has a proper URL")
    public void assertJDIisLinkAndHasProperURL() {
        assertIsDisplayed(hp.getJdiLink());
        assertProperLinkValue(hp.getJdiLink(), hp.JDI_LINK_URL);
    }

    @Step("Switch to iFrame and check there is a logo in the left top corner of it")
    public void switchToIFrameAndCheckLogo() {
        switchToIFrame();
        assertIsDisplayed(hp.getEpamLogo());
    }
    public void switchToIFrame() {
        driver.switchTo().frame("iframe");
    }

    @Step("Switch back to original window")
    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    @Step("Assert page title")
    public void assertPageTitle(String title) {
        assertEquals(hp.getPageTitle(), title);
    }

    @Step("Assert that there is the iframe in the center of page")
    public void assertIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void assertProperLinkValue(WebElement element, String expectedHrefValue) {
        assertEquals(element.getAttribute("href"), expectedHrefValue);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderSectionItems(List<String> expectedHeaderMenuText, int size) {
        // TODO el -> el.getName() could be
        //  replaced to WebElement::getText =>
        //  it couldn't, I'm iterating over an enum
        List<String> actualTopMenuElements = Stream.of(TopMenu.values())
                .map(TopMenu::getName).collect(Collectors.toList());

        assertEquals(hp.getMenuItems().size(), size);
        assertEquals(actualTopMenuElements, expectedHeaderMenuText);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertPageElements(List<WebElement> elementList, int size) {
        assertEquals(elementList.size(), size);

        SoftAssert sa = new SoftAssert();
        for (WebElement image: hp.getImages()) {
            sa.assertTrue(image.isDisplayed());
        }
        sa.assertAll();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTexts(List<String> textContents, List<String> expectedContents) {
        assertEquals(textContents, expectedContents);
        this.assertPageElements(hp.getTexts(), 4);
    }

    @Step("Assert a text of the main headers")
    public void assertMainHeadersText() {
        assertIsDisplayed(hp.getMainTitle());
        assertEquals(hp.getMainTitle().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(hp.getMainText().getText().contains("LABORIS NISI UT ALIQUIP EX " +
                "EA COMMODO CONSEQUAT DUIS AUTE"));
    }

    @Step("Assert a text of the sub header")
    public void assertSubHeaderText() {
        assertEquals(hp.getSubHeader().getText(), "JDI GITHUB");
    }

}