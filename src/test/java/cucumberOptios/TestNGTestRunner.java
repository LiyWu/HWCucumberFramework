package cucumberOptios;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/features",glue= "stepDefinitions",monochrome=true,tags="@PlaceOrder",plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

}
