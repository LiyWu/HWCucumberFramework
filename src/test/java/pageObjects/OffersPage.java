package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;
    public OffersPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//table//tbody/tr/td[1]");

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public void clickDeal()
    {
         driver.findElement(By.xpath("//a[@class='cart-header-navlink'][contains(text(),'Deals')]")).click();
    }
    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }
}
