package hw6;

import hw6.enums.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickTopMenuElement(TopMenu menuItem) {
        driver.findElement(By.xpath("//ul[contains(@class, 'nav')]//a[contains(text(), '" + menuItem.getName() + "')]")).click();
    }
}