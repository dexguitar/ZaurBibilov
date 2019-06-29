package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableWithPagesPage extends BasePage {

    private SelenideElement rightSection = $(By.xpath("//*[contains(@class, 'right-fix-panel')]"));
    private SelenideElement leftSection = $("#mCSB_1");
    private SelenideElement dropdownLogRow = $(By.xpath("//li[contains(text(), 'value') and contains(text(), '10')]"));
    private ElementsCollection tableRows = $$("tbody tr");
    private ElementsCollection searchResultsRows = $$(By.xpath("//tbody//td[contains(text(), 'Custom')]"));

    public ElementsCollection getSearchResultsRows() {
        return searchResultsRows;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    private SelenideElement searchField = $(By.xpath("//label[contains(text(), 'Search:')]//input"));

    public ElementsCollection getTableRows() {
        return tableRows;
    }

    public SelenideElement getDropdownLogRow() {
        return dropdownLogRow;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public SelenideElement getEntryOptionByValue(int value) {
        return $(By.xpath("//option[@value='" + value + "']"));
    }
}
