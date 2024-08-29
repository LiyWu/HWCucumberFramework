package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//h4[@class='product-name']");

    By topDeals = By.xpath("//a[@class='cart-header-navlink'][contains(text(),'Deals')]");

    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchText()
    {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void incrementQuantity(int quantity)
    {
        int i = quantity-1;
        while(i>0)
        {
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart()
    {
        driver.findElement(addToCart).click();
    }
    public void selectTopDeals()
    {
        driver.findElement(topDeals).click();
    }

    public void clickDeal()
    {
        driver.findElement(By.xpath("//a[@class='cart-header-navlink'][contains(text(),'Deals')]")).click();
    }

    public String getTitleLandingPage()
    {
        return driver.getTitle();
    }

}
