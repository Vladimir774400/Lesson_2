import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xpath.operations.Bool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;
    @Before
    public void setUp() throws Exception
    {
        System.out.println("- Запускаю тест.");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.1");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:/Users/vnartov/Desktop/JavaAppiumAutomatization/apks/org.wikipedia_50362_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown()
    {
        System.out.println("- Завершение теста.");
        driver.quit();
    }

    @Test
    public void testAssertSearchText ()
    {
        waitForElemAndClick(By.xpath("//*[contains(@text,'SKIP')]"),
                "Кнопка SKIP не отображается в течении 5 секунд",
                5);

        waitForElemAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Поле 'Search Wikipedia' не отображается",
                5);

        waitForElemByAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Dzigurda",
                "Обьект 'Search Wikipedia' не отображается в течении 5 секунд",
                5);

            assertElementContainsText(
                    By.id("org.wikipedia:id/page_list_item_title"),
                    "Java",
                    "В результатах не содержится слов Java",
                    "Результаты поиска не отобразились в течении 10 секунд",
                    10
            );

        System.out.println("- Тест пройден успешно!");
    }


    //Методы
    private WebElement waitForElem(By by, String error_message, long timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    private WebElement waitForElemAndClick(By by, String error_message, long timeOutInSec)
    {
           WebElement element = waitForElem(by, error_message, timeOutInSec);
           element.click();
           return element;
    }



    private WebElement waitForElemByAndSendKeys(By by, String value, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        element.sendKeys(value);
        return element;
    }



    private WebElement waitForElemAndClear(By by, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        element.clear();
        return element;
    }



    private boolean waitForElemNotPresent(By by, String error_message, long timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



    private WebElement assertElementHasText(By by, String value, String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertEquals(assert_error_message,
                value,
                textValue);
        return element;
    }

    private WebElement assertElementContainsText(By by, String value,  String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertTrue(assert_error_message,textValue.contains(value));
        return element;
    }

}
