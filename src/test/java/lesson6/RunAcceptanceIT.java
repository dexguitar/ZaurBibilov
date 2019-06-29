package lesson6;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:lesson6"},
        glue = {"classpath:lesson6"},
        tags = {"~@skip"}
)
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {
}