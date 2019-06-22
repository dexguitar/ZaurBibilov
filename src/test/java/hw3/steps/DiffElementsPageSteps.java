package hw3.steps;

import hw3.enums.TopMenu;
import hw3.voids.DiffElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public class DiffElementsPageSteps {

    private WebDriver driver;
    private HomePage homePage;
    private DiffElementsPage diffElementsPage;

    public DiffElementsPageSteps(WebDriver driver) {
        this.driver = driver;
        diffElementsPage = new DiffElementsPage(driver);
        homePage = new HomePage(driver);
    }

    public void clickServiceItem() {
        diffElementsPage.clickTopMenu(TopMenu.SERVICE);
    }

    public void clickDifferentElementsLink() {
        homePage.getDifferentElementsLink().click();
    }

    public void clickWaterCheckbox() {
        diffElementsPage.getWaterCheckbox().click();
    }

    public void clickWindCheckbox() {
        diffElementsPage.getWindCheckbox().click();
    }

    public void checkSelen() {
        diffElementsPage.getSelenCheckbox().click();
    }

    public void selectYellowinDropdown() {
        diffElementsPage.getYellowDropdownOption().click();
    }

}