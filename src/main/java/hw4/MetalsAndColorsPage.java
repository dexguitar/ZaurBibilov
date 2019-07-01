package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.ElementsTable;
import hw4.enums.NumbersDropdown;
import hw4.enums.VegetablesDropdown;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class MetalsAndColorsPage extends BasePage {

//    Selectors
    private SelenideElement oddNumSelector = $("#odds-selector");
    private SelenideElement evenNumSelector = $("#even-selector");
    private SelenideElement elementSelector = $(By.xpath("//*[@id='elements-checklist']"));

    //    Rows
    // TODO Why dou you use $(By.cssSelector("")) instead of $("")
    private SelenideElement summaryRow = $(By.cssSelector(".summ-res"));
    private SelenideElement elementsRow = $(By.cssSelector(".elem-res"));
    private SelenideElement colorRow = $(By.cssSelector(".col-res"));
    private SelenideElement metalRow = $(By.cssSelector(".met-res"));
    private SelenideElement vegetableRow = $(By.cssSelector(".sal-res"));

    //    Submit button
    private SelenideElement submitBtn = $("#submit-button");

    public SelenideElement getSubmitBtn() {
        return submitBtn;
    }

    public void clickNumbers(List<NumbersDropdown> numbers) {
        for (NumbersDropdown number: numbers) {
            if (number.getNumber() % 2 == 0) {
                evenNumSelector.find(By.xpath("//label[contains(text(), '" +
                        number.getNumber() + "')]")).click();
            }
            oddNumSelector.find(By.xpath("//label[contains(text(), '" +
                    number.getNumber() + "')]")).click();
        }
    }

    public int getSummary(int odd, int even) {
        return odd + even;
    }

    public void summaryCheck(int summary) {
        summaryRow.shouldHave(Condition.text("Summary: " + summary));
    }

    public void clickElements(List<ElementsTable> elements) {
        for (ElementsTable element: elements) {
            elementSelector.find(By.xpath("//label[contains(text(), '" + element.getName() + "')]")).click();
        }
    }

    public void elementsCheck(List<ElementsTable> elements) {
        for (ElementsTable element: elements) {
            elementsRow.shouldHave(Condition.text(element.getName()));
        }
    }

    public void clickColor(String color) {
        $(By.xpath("//span[@class='filter-option pull-left' and contains(text(), 'Colors')]")).click();
        $(By.xpath("//span[@class='text' and contains(text(), '" + color + "')]")).click();
    }

    public void colorCheck(String color) {
        colorRow.shouldHave(Condition.text(color));
    }

    public void clickMetal(String metal) {
        $(By.xpath("//button[@type='button' and contains(.//span, 'Metals')]/span[@class='caret']")).click();
        $(By.xpath("//a[contains(.//span, '" + metal + "')]")).click();
    }

    public void metalCheck(String metal) {
        metalRow.shouldHave(Condition.text(metal));
    }

    public void clickVegetables(List<VegetablesDropdown> vegetables) {
        $("#salad-dropdown button").click();
        for (VegetablesDropdown vegetable: vegetables) {
            $(By.xpath("//div[@id='salad-dropdown']//label[contains(., '" + vegetable.getVegetable() + "')]")).click();
        }
    }

    public void vegetableCheck(List<VegetablesDropdown> vegetables) {
        for (VegetablesDropdown vegetable: vegetables) {
            vegetableRow.shouldHave(Condition.text(vegetable.getVegetable()));
        }
    }

}