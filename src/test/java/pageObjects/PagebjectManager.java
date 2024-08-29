package pageObjects;

import org.openqa.selenium.WebDriver;

public class PagebjectManager {

    private LandingPage landingPage;
    private OffersPage offerPage;
    private CheckoutPage checkoutPage;
    private WebDriver driver;
    public PagebjectManager(WebDriver driver)
    {
        this.driver = driver;
    }
    public LandingPage getLandingPage()
    {
        landingPage = new LandingPage(driver);
        return landingPage;
    }
    public OffersPage getOffersPage()
    {
        offerPage = new OffersPage(driver);
        return offerPage;
    }
    public CheckoutPage getCheckoutPage()
    {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
