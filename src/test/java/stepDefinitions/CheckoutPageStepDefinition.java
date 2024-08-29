package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pagebjectManager.getCheckoutPage();
    }

    @Then("validate user has the promo code and place the order")
    public void validate_user_has_the_promo_code_and_place_the_order()
    {

        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlanOrder());
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceed_to_checkout(String name) throws InterruptedException {
        checkoutPage.checkoutItems();
        //Thread.sleep(2000);
        //Assertion to extract name from screen and compare with name
    }

}
