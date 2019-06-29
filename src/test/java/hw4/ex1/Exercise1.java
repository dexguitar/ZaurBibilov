package hw4.ex1;

import base.SelenideBaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.TopMenu;
import hw4.HomePage;
import hw4.TableWithPagesPage;
import hw4.enums.ServiceDropdown;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class Exercise1 extends SelenideBaseTest {

    @Test
    public void tableWithPagesTest() {

        HomePage hp = new HomePage();
        TableWithPagesPage twpp = new TableWithPagesPage();

//        Click on "Service" subcategory in the header
//        and check that drop down contains options:
//        "Support, Dates, Complex Table, Simple Table,
//        Tables With Pages, Different Elements"
        hp.clickTopMenu(TopMenu.SERVICE);

        List<String> expectedOptions = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE",
                "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
        hp.checkDropdownContainsElements(hp.getTopServiceDropdownElements(), expectedOptions);

//        Open through the header menu Service -> Table with pages
        hp.clickServiceDropdownOption(ServiceDropdown.TABLE_WITH_PAGES);

        hp.getPageTitle().shouldHave(attribute("text", "Table with pages"));

//        Check that default value for “Show entries” dropdown is 5
        twpp.getEntryOptionByValue(5).shouldHave(attribute("selected", "true"));

//        Assert that there is Right Section
        twpp.getRightSection().shouldBe(visible);

//        Assert that there is Left Section
        twpp.getLeftSection().shouldBe(visible);

//        Select new value for the entries in the dropdown list: 10
        twpp.getEntryOptionByValue(10).click();
        twpp.getEntryOptionByValue(10).shouldHave(attribute("selected", "true"));

//        Assert that for the dropdown there is
//        an individual log row and value corresponds to the value of dropdown.
        twpp.getDropdownLogRow().shouldBe(visible);

//        Assert that in the table displayed corrected amount of entries
        twpp.getTableRows().shouldHave(CollectionCondition.size(10));

//        Type in “Search” text field: Custom
//        +
//        Assert the table contains only records with Search field value
        twpp.getSearchField().sendKeys("Custom");
        for (SelenideElement element : twpp.getSearchResultsRows()) {
            element.shouldHave(text("Custom"));
        }
    }

}