package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    String offerpageProductName;

    OffersPage offersPage;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        offersPage = testContextSetup.pagebjectManager.getOffersPage();
    }
    @Then("^user searched for (.+) shortname in offers page$")
    public void user_search_for_same_shortname_in_offers_page(String shortName) {

        switchToOffersPage();
        offersPage.searchItem(shortName);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tbody/tr/td[1]")));
        offerpageProductName =offersPage.getProductName();
        System.out.println(offerpageProductName + " is extracted from offer Page");
    }

    public void switchToOffersPage()
    {
            LandingPage landingPage = testContextSetup.pagebjectManager.getLandingPage();
            landingPage.selectTopDeals();
            landingPage.clickDeal();
            testContextSetup.utils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page()
    {
        Assert.assertEquals(testContextSetup.productName,offerpageProductName);
    }
}
