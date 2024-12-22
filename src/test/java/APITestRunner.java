import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty", "html:target/reports.html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"},
        glue={"com/fisPages/stepdefs"},
        features="src/test/resources/features/",
        tags="@apitest1",
        monochrome=true)
public class APITestRunner
{

}
