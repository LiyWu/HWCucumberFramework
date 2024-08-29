package utils;

import io.cucumber.java.lv.Un;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Untils {

    public WebDriver driver;
    public Untils(WebDriver driver){
        this.driver = driver;
    }
    public void switchWindowToChild()
    {
        Set<String> s = driver.getWindowHandles();
        Iterator<String> i1 = s.iterator();
        String parentWindow = i1.next();
        String childwindows = i1.next();

        driver.switchTo().window(childwindows);
    }
}
