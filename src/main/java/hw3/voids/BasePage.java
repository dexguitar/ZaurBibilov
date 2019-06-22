package hw3.voids;

import hw3.enums.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTopMenu(TopMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

}