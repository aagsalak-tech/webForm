package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        monochrome = true
)

public class TestRunner {


}
