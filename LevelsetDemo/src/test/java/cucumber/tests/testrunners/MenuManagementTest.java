package cucumber.tests.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber/tests/features", glue = "stepdefinitions", plugin = {"pretty"})
public class MenuManagementTest {
}
