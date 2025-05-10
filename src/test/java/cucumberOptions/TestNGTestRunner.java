package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listener.TestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
@CucumberOptions(features="src/test/java/features",glue= "stepDefinitions",monochrome=true,tags="@PlaceOrder or @OffersPage",plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

}
