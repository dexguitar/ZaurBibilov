package hw4.builder;

import hw4.enums.ElementsTable;
import hw4.enums.NumbersDropdown;
import hw4.enums.VegetablesDropdown;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Builder
@ToString
@Getter
public class ResultsBlockLombok {

    @Builder.Default
    private List<NumbersDropdown> numbers = Arrays.asList(NumbersDropdown.ONE, NumbersDropdown.TWO);
    @Builder.Default
    private List<ElementsTable> elements = Arrays.asList();
    @Builder.Default
    private String color = "Colors";
    @Builder.Default
    private String metal = "Metals";
    @Builder.Default
    private List<VegetablesDropdown> vegetables = Arrays.asList();

}