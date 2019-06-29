package hw4.ex2;

import base.SelenideBaseTest;
import com.codeborne.selenide.Condition;
import hw3.enums.TopMenu;
import hw4.HomePage;
import hw4.MetalsAndColorsPage;
import hw4.builder.ResultsBlockLombok;
import hw4.enums.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Exercise2 extends SelenideBaseTest {

    HomePage hp = new HomePage();
    MetalsAndColorsPage mcp;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        mcp = open("https://epam.github.io/JDI/metals-colors.html", MetalsAndColorsPage.class);
    }

    @DataProvider(name = "results block builder")
    public Object[][] builder() {
        return new Object[][]{
                {ResultsBlockLombok.builder()
                        .elements(Arrays.asList(ElementsTable.EARTH))
                        .color(ColorsDropdown.YELLOW.getColor())
                        .metal(MetalsDropdown.GOLD.getMetal())
                        .build()
                },
                {ResultsBlockLombok.builder()
                        .numbers(Arrays.asList(NumbersDropdown.THREE, NumbersDropdown.EIGHT))
                        .vegetables(Arrays.asList(VegetablesDropdown.CUCUMBER, VegetablesDropdown.TOMATO))
                        .build()
                },
                {ResultsBlockLombok.builder()
                        .numbers(Arrays.asList(NumbersDropdown.THREE, NumbersDropdown.TWO))
                        .elements(Arrays.asList(ElementsTable.WIND, ElementsTable.FIRE, ElementsTable.WATER))
                        .metal("Bronze")
                        .vegetables(Arrays.asList(VegetablesDropdown.ONION))
                        .build()
                },
                {ResultsBlockLombok.builder()
                        .numbers(Arrays.asList(NumbersDropdown.FIVE, NumbersDropdown.SIX))
                        .elements(Arrays.asList(ElementsTable.WATER))
                        .color("Green")
                        .metal("Selen")
                        .vegetables(Arrays.asList(VegetablesDropdown.ONION, VegetablesDropdown.CUCUMBER
                                , VegetablesDropdown.TOMATO, VegetablesDropdown.VEGETABLES))
                        .build()
                },
                {ResultsBlockLombok.builder()
                        .elements(Arrays.asList(ElementsTable.FIRE))
                        .color("Blue")
                        .vegetables(Arrays.asList(VegetablesDropdown.CUCUMBER, VegetablesDropdown.TOMATO, VegetablesDropdown.VEGETABLES))
                        .build()
                }
        };
    }

    @Test(dataProvider = "results block builder")
    public void metalsAndColorsPageTest(ResultsBlockLombok resultsBlock) {

//      Click the link in the Header section
        hp.clickTopMenu(TopMenu.METALS_AND_COLORS);

        $("title").shouldHave(Condition.attribute("text", "Metal and Colors"));

//      Fill form on the page, click button and check results
        if (resultsBlock.getNumbers() != null) {
            mcp.clickNumbers(resultsBlock.getNumbers());
            int summary = mcp.getSummary(resultsBlock.getNumbers().get(0).getNumber(),
                    resultsBlock.getNumbers().get(1).getNumber());
            mcp.getSubmitBtn().click();
            mcp.summaryCheck(summary);
        }


        if (resultsBlock.getElements() != null) {
            mcp.clickElements(resultsBlock.getElements());
            mcp.getSubmitBtn().click();
            mcp.elementsCheck(resultsBlock.getElements());
        }

        if (resultsBlock.getColor() != null) {
            mcp.clickColor(resultsBlock.getColor());
            mcp.getSubmitBtn().click();
            mcp.colorCheck(resultsBlock.getColor());
        }

        if (resultsBlock.getMetal() != null) {
            mcp.clickMetal(resultsBlock.getMetal());
            mcp.getSubmitBtn().click();
            mcp.metalCheck(resultsBlock.getMetal());
        }

        if (resultsBlock.getVegetables() != null) {
            mcp.clickVegetables(resultsBlock.getVegetables());
            mcp.getSubmitBtn().click();
            mcp.vegetableCheck(resultsBlock.getVegetables());
        }

    }

}
