package hw2.ex1;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTest {

    @DataProvider(name = "login data")
    public Object[][] loginData() {
        return new Object[][]{
                {"epam", "1234"}
        };
    }

    @DataProvider(name = "menu elements")
    public Object[][] menuElements() {
        return new Object[][]{
                {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"}
        };
    }

    @Test(dataProvider = "login data")
    public void loginTest(String login, String password) {
//        Open test site by URL
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

//        Assert The Browser title
        assertEquals(driver.getTitle(), "Home Page");

//        Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

//        Assert User name in the left-top side of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }

    @Test(dataProvider = "menu elements")
    public void pageContentTest(String el1, String el2, String el3, String el4) {
//        Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

//        Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> topMenuElements = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav " +
                "m-l8']/li"));
        assertEquals(topMenuElements.size(), 4);
        assertEquals(topMenuElements.get(0).getText(), el1);
        assertEquals(topMenuElements.get(1).getText(), el2);
        assertEquals(topMenuElements.get(2).getText(), el3);
        assertEquals(topMenuElements.get(3).getText(), el4);

//        Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='benefit-icon']//span"));
        assertEquals(images.toArray().length, 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(images.get(i).isDisplayed());
        }

//        Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.toArray().length, 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(texts.get(i).isDisplayed());
        }
        assertTrue(texts.get(0).getText().contains("include good practices\n" +
                "and ideas from successful"));
        assertTrue(texts.get(1).getText().contains("be flexible and\n" +
                "customizable"));
        assertTrue(texts.get(2).getText().contains("be multiplatform"));
        assertTrue(texts.get(3).getText().contains("about 20 internal and\n" +
                "some external projects"));

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
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

//        Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

}
