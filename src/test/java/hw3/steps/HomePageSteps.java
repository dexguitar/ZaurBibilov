package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.HomePage;
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

    public void switchToIFrame() {
        driver.switchTo().frame("iframe");
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    public void assertPageTitle(String title) {
        assertEquals(hp.getPageTitle(), title);
    }

    public void assertIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void assertProperLinkValue(WebElement element, String expectedHrefValue) {
        assertEquals(element.getAttribute("href"), expectedHrefValue);
    }

    public void assertHeaderSectionItems(List<String> expectedHeaderMenuText, int size) {
        // TODO el -> el.getName() could be
        //  replaced to WebElement::getText =>
        //  it couldn't, I'm iterating over an enum
        List<String> actualTopMenuElements = Stream.of(TopMenu.values())
                .map(el -> el.getName()).collect(Collectors.toList());

        assertEquals(hp.getMenuItems().size(), size);
        assertEquals(actualTopMenuElements, expectedHeaderMenuText);
    }

    public void assertPageElements(List<WebElement> elementList, int size) {
        assertEquals(elementList.size(), size);

        SoftAssert sa = new SoftAssert();
        for (WebElement image: hp.getImages()) {
            sa.assertTrue(image.isDisplayed());
        }
        sa.assertAll();
    }

    public void assertTexts(List<String> textContents, List<String> expectedContents) {
        assertEquals(textContents, expectedContents);
        this.assertPageElements(hp.getTexts(), 4);
    }

    public void assertMainHeadersText() {
        assertIsDisplayed(hp.getMainTitle());
        assertEquals(hp.getMainTitle().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(hp.getMainText().getText().contains("LABORIS NISI UT ALIQUIP EX " +
                "EA COMMODO CONSEQUAT DUIS AUTE"));
    }

    public void assertSubHeaderText() {
        assertEquals(hp.getSubHeader().getText(), "JDI GITHUB");
    }

}