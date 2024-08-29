//package mobile;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.ios.IOSDriver;
//
//import java.net.URL;
//
//public class AppiumSetup {
//    public static AppiumDriver appiumDriver(String platform) throws Exception
//    {
//        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\ApiDemos-debug.apk";
//
//        /*UiAutomator2Options options = new UiAutomator2Options().setDeviceName("pixel_8_pro").
//                setAutomationName("uiAutomator2").setApp(filePath);*/
//        UiAutomator2Options options = new UiAutomator2Options();
//        //options.setNewCommandTimeout(Duration.ofSeconds(300));
//        URL url = new URL("http://0.0.0.0:4723");
//
//        switch (platform) {
//            case "Android":
//                options.setDeviceName("pixel_8_pro").
//                        setAutomationName("uiAutomator2").
//                        setAppPackage("org.telegram.messenger").
//                        setAppActivity("org.telegram.messenger.DefaultIcon").setNoReset(true).setFullReset(false);
//                return new AndroidDriver(url, options);
//            case "iOS":
//                options.setDeviceName("iphone 13").setAutomationName("XCUITest").setUdid("").setUdid("shoubebe bundleId");
//                return new IOSDriver(url, options);
//            default:
//                throw new Exception("invalid platform");
//        }
//
//    }
//
//
//}
