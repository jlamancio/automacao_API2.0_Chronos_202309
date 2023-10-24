package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@LoginInvalido",
        glue = "steps",
        plugin = {"json:target/reports/cucumber-Reports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
