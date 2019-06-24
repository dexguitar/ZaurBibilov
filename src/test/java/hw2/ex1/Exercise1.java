package hw2.ex1;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise1 extends BaseTest {

    @Test
    public void pageContentTest() {
//        Assert browser title
        checkOpenPageTitle("Home Page");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedHeaderMenuText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> topMenuElements = driver.findElements(By.xpath("//ul[contains(@class, " +
                "'uui-navigation nav navbar')]/li"));

        checkSizeAndContains(topMenuElements, expectedHeaderMenuText, 4);

//        Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='benefit-icon']//span"));
        assertEquals(images.size(), 4);

        SoftAssert softAssert = new SoftAssert();
        for (WebElement image: images) {
            softAssert.assertTrue(image.isDisplayed());
        }
        softAssert.assertAll();

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
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

        checkSizeAndContains(texts, expectedTextContents, 4);
        for (WebElement text:texts) {
            softAssert.assertTrue(text.isDisplayed());
        }
        softAssert.assertAll();

//        Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.className("main-txt")).getText().contains("LABORIS NISI UT ALIQUIP EX " +
                "EA COMMODO CONSEQUAT DUIS AUTE"));

//        Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.tagName("iframe")).isDisplayed());

//        Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());

//        Switch back to original window
        driver.switchTo().defaultContent();

//        Assert a text of the sub header
        assertEquals(driver.findElement(By.xpath("//h3[@class='text-center']/a")).getText(), "JDI GITHUB");

//        Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(driver.findElement(By.xpath("//h3[@class='text-center']/a"))
                .isDisplayed());
        assertEquals(driver.findElement(By.xpath("//h3[@class='text-center']/a"))
                .getAttribute("href"), "https://github.com/epam/JDI");

//        Assert that there is Left Section
        checkElementIsDisplayed(driver.findElement(By.id("mCSB_1")));

//        Assert that there is Footer
        checkElementIsDisplayed(driver.findElement(By.tagName("footer")));
    }

}