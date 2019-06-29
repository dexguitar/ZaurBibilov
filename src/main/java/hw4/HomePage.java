package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {

    private ElementsCollection topServiceDropdownElements = $$(By.xpath("//ul[@class='dropdown-menu']//li"));

    public ElementsCollection getTopServiceDropdownElements() {
        return topServiceDropdownElements;
    }

    public void checkDropdownContainsElements(ElementsCollection dropdown, List<String> expectedContents) {
        for (String element : expectedContents) {
            dropdown.findBy(Condition.text(element)).shouldBe(Condition.visible);
        }
    }
}