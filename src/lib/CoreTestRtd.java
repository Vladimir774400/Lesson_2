package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestRtd extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";


    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        System.out.println("- Запускаю тест.");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidRtdTestDevice");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","com.mvideo.rtd_android");
        capabilities.setCapability("appActivity",".features.auth.AuthActivity");
        capabilities.setCapability("app","C:/Users/vnartov/Desktop/JavaAppiumAutomatization/apks/release_AND.21.6.x.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);

    }

    @Override
    public void tearDown() throws Exception
    {
        System.out.println("- Завершение теста.");
        driver.quit();
        super.tearDown();
    }
}
