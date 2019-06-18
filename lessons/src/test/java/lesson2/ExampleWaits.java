package lesson2;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ExampleWaits extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        driver.get("https://amazon.com");
    }

    @Test
    public void waitsTest() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//span[contains(., 'Departments')]")))
                .build()
                .perform();

        assertTrue(driver.findElement(By.id("nav-flyout-shopAll")).isDisplayed());

        WebElement webElement = new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.id("nav-flyout-shopAll"))));

        assertTrue(webElement.isDisplayed());

        String webText = new WebDriverWait(driver, 15)
                .until(new ExpectedCondition<String>() {
                    @NullableDecl
                    @Override
                    public String apply(@NullableDecl WebDriver webDriver) {
                        String text = "";
                        if (driver.findElement(By.id("nav-flyout-shopAll")).isDisplayed()) {
                            text = driver.findElement(By.id("nav-flyout-shopAll")).getText();
                        }
                        return text;
                    }
                });

        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File("src/image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(webText);
    }

}