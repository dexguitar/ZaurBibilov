package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class AddTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {2L, 2L, 4L},
                {0L, 0L, 0L},
                {-15L, 12L, -3L},
                {-23L, -15L, -38L},
//                Boundary values
                {-9223372036854775808L, 9223372036854775807L, -1L}
        };
    }

    @BeforeClass
    public void setUp() {
        System.out.println("This runs before the class");
        calculator = new Calculator();
    }

    @Test(dataProvider = "test data", groups = {"addSub"})
    public void AdditionTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the AddTest Class***");
    }

}
