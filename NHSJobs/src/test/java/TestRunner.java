
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
glue = { "StepDefinitions" }, 
monochrome = true,
plugin = { "html:target/cucumber-reports/cucumber.html" }, tags = "@Search")
public class TestRunner {

}
