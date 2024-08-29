package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PagebjectManager;

import java.io.IOException;
import java.time.Duration;

public class TestContextSetup {
    //public WebDriver driver;
    public String productName;
    public WebDriverWait wait;

    public PagebjectManager pagebjectManager;
    public TestBase testBase;

    public Untils utils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pagebjectManager = new PagebjectManager(testBase.WebDriverManager());
        wait = new WebDriverWait(testBase.WebDriverManager(), Duration.ofSeconds(10));
        utils = new Untils(testBase.WebDriverManager());
    }
}
