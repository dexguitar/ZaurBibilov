package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class isNegativeTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {-15L, true},
                {324L, false},
//                Boundary values
                {-9223372036854775808L, true},
                {9223372036854775807L, false},
                {0, false}
        };
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        System.out.println("***This runs before the isNegativeTest Class***");
    }

    @Test(dataProvider = "test data", groups = {"allTests"})
    public void isNegativeTest(long a, boolean expected) {
        boolean actual = calculator.isNegative(a);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the isNegativeTest Class***");
    }

}
