package lesson3.voids;

import lesson3.enums.LeftSideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLeftSideMenu(LeftSideMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}