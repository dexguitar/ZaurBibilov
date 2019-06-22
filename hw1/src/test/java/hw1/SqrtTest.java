package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SqrtTest {

    Calculator calculator;

    @DataProvider(name = "test data")
    public static Object[][] testData() {
        return new Object[][]{
                {16, 4},
                {9.7344, 3.12},
                {20489.918449, 143.143},
//                Boundary values
                {0, 0}
        };
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        System.out.println("***This runs before the SqrtTest Class***");
    }

    @Test(dataProvider = "test data", groups = {"allTests"})
    public void SquareRootTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***This runs after the SqrtTest Class***");
    }

}
