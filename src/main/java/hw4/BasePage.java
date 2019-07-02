package hw4;

import com.codeborne.selenide.SelenideElement;
import hw3.enums.TopMenu;
import hw4.enums.ServiceDropdown;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    // TODO Coudle be used Selenide.title()
    private SelenideElement pageTitle = $("title");

    public SelenideElement getPageTitle() {
        return pageTitle;
    }

    public void clickTopMenu(TopMenu menuItem) {
        $(By.linkText(menuItem.getName())).click();
    }

    public void clickServiceDropdownOption(ServiceDropdown dropdownOption) {
        $(By.linkText(dropdownOption.getName())).click();
    }

}