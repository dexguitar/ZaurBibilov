package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MulTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {-4L, 3L, -12L},
                {3L, 0L, 0L},
                {-12L, -3L, 36L},
                {12L, 11L, 132L},
//                Boundary values
                {9223372036854775807L, 1L, 9223372036854775807L}
        };
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        System.out.println("***This runs before the MulTest Class***");
    }

    @Test(dataProvider = "test data", groups = {"mulDiv", "allTests"})
    public void MultiplicationTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the MulTest Class***");
    }

}