//package mobile;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//import java.time.Duration;
//
//public class telegramVantage {
//
//    public static void main(String[] args) throws Exception {
//        AppiumDriver driver = AppiumSetup.appiumDriver("Android");
//        System.out.println(driver.getSessionId());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        By startM = By.xpath("//android.widget.TextView[@text='Start Messaging']");
//        By ContinueBtn = By.xpath("//android.widget.TextView[@text='Continue']");
//        By notAllowBtn =  AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
//        By countryCode = AppiumBy.accessibilityId("Country code");
//        By phoneNum = AppiumBy.accessibilityId("Phone number");
//        By DoneBtn = By.xpath("//android.widget.FrameLayout[@content-desc=\"Done\"]/android.view.View");
//        By allowContinueBtn = AppiumBy.xpath("//android.widget.TextView[@text=\"Continue\"]");
//        By dontaccessBtn = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
//        By dontallowBtn = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button");
//
//        driver.findElement(startM).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueBtn)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(notAllowBtn)).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(countryCode)).sendKeys("61");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNum)).sendKeys("0402071678");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(DoneBtn)).click();
//
//        // Send the Enter key event
//        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(allowContinueBtn)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dontaccessBtn)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dontallowBtn)).click();
//
//        By turnOnNotif = By.xpath("//android.widget.TextView[@text=\"Continue\"]");
//        By noNotification = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
//        By thirdGroup = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
//        By loginBtn = By.xpath("//android.widget.TextView[@text=\"⭐\uFE0F Login\"]");
//        By start = By.xpath("//android.widget.TextView[@text=\"Start\"]");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOnNotif)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(noNotification)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdGroup)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(start)).click();
//
//
//
//
//    }
//
//}
