package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {-12L, 3L, -4L},
                {-15L, -3L, 5L},
                {16L, 3L, 5L},
//                Boundary values
                {-9223372036854775808L, -9223372036854775808L, 1L}
        };
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        System.out.println("***This runs before the DivTest Class***");
    }

    @Test(dataProvider = "test data", groups = {"mulDiv", "allTests"})
    public void DivisionTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the DivTest Class***");
    }

}
