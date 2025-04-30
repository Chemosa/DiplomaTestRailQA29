package uiTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.Data;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumberSteps"
//        tags = "@all",
//        snippets = CucumberOptions.SnippetType.UNDERSCORE,
//        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber.html",
//                "json:target/cucumber-reports/cucumber.json"
//        }
)
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {
}