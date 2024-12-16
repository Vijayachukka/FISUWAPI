import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty", "html:target/reports.html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@regressionpack",
        monochrome = true)
public class FISTestRunner
{
}
