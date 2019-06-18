package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {15L, 11L, 4L},
                {0L, 0L, 0L},
                {3L, 11L, -8L},
                {-34L, -12L, -22L},
//                Boundary values
                {9223372036854775807L, 9223372036854775806L, 1L}
        };
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        System.out.println("***This runs before the SubTest Class***");
    }

    @Test(dataProvider = "test data", groups = {"addSub", "allTests"})
    public void SubtractionTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the SubTest Class***");
    }

}
