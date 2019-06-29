package lesson6;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:lesson6"},
        glue = {"classpath:lesson6"},
        tags = {"@run", "~@skip"}
)
public class RunAcceptanceRunWithoutSkipIT extends AbstractTestNGCucumberTests {
}