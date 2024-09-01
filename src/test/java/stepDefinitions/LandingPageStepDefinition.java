package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinition {
    String offerpageProductName;
    TestContextSetup testContextSetup;

    LandingPage lp;

    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        this.lp = testContextSetup.pagebjectManager.getLandingPage();
    }
    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
        // Write code here that turns the phrase above into concrete action
        Assert.assertTrue(lp.getTitleLandingPage().contains("GreenKart"));
    }
    @When("^user seached with the shortname (.+) and extracted actual name$")
    public void user_seached_with_the_shortname_and_extracted_actual_name(String shortname) throws Exception{


        lp.searchItem(shortname);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='product-name']")));
        Thread.sleep(2000);
        testContextSetup.productName = lp.getSearchText().split("-")[0].trim();
        System.out.println(testContextSetup.productName + " is extracted from Home Page");
    }

    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
        lp.incrementQuantity(Integer.parseInt(quantity));
        lp.addToCart();
    }
}
