//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.net.URL;
//
//public class testRTD {
//    private AppiumDriver driver;
//    @Before
//    public void setUp() throws Exception
//    {
//        System.out.println("- Запускаю тест.");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName","Android");
//        capabilities.setCapability("deviceName","AndroidRtdTestDevice");
//        capabilities.setCapability("platformVersion","9");
//        capabilities.setCapability("automationName","Appium");
//        capabilities.setCapability("appPackage","com.mvideo.rtd_android");
//        capabilities.setCapability("appActivity",".features.auth.AuthActivity");
//        capabilities.setCapability("app","C:/Users/vnartov/Desktop/JavaAppiumAutomatization/apks/release_AND.21.6.x.apk");
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//    //@After
//    public void tearDown()
//    {
//        System.out.println("- Завершение теста.");
//        driver.quit();
//    }
//
//    @Test
//    public void orderStatusTest ()
//    {
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/debugToolsButton"),
//                "Кнопка Debug тулов не отображается",
//                5);
//
//        waitForElemAndClear(By.id("com.mvideo.rtd_android:id/rlBaseUrl"),
//                "Поле с урлом не отобразилось в течении 5 сек",
//                5);
//
//        waitForElemByAndSendKeys(
//                By.id("com.mvideo.rtd_android:id/rlBaseUrl"),
//                "http://uat3.rtd.corp.mvideo.ru/",
//                "Поле с урлом не отобразилось в течении 5 сек",
//                5);
//
//        waitForElemByAndSendKeys(
//                By.id("com.mvideo.rtd_android:id/etEmployeeId"),
//                "6715",
//                "Поле ТН не отобразилось в течении 5 сек",
//                5);
//
//        waitForElemByAndSendKeys(
//                By.id("com.mvideo.rtd_android:id/etShopId"),
//                "111",
//                "Поле магазином не отобразилось в течении 5 сек",
//                5);
//
//        driver.navigate().back();
//
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/cbDebugInfo"),
//                "Чек-бокс Debug инфы не отображается",
//                5);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/cbDebugLog"),
//                "Чек-бокс логов не отображается",
//                5);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/btnLogin"),
//                "Кнопка войти не отображается",
//                5);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/dialogOk"),
//                "Кнопка ДА не отображается",
//                5);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/transparentEmployeeBtn"),
//                "Кнопка сотрудника не отображается",
//                10);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/orderStatusBtn"),
//                "Кнопка получения стауса заказа не отображается",
//                10);
//
//        String order_number = "2128060265";
//
//        waitForElemByAndSendKeys(
//                By.id("com.mvideo.rtd_android:id/inputEditText"),
//                order_number,
//                "Поле номера заказа не отобразилось в течении 5 сек",
//                5);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/checkOrderStatusButton"),
//                "Кнопка 'Проверить' не отображается",
//                10);
//
//        waitForElem(By.xpath("//*[@text='Заказ № "+order_number+"']"),
//                "Не найден заголовок с номером заказа "+order_number,
//                15);
//
//        waitForElem(By.id("com.mvideo.rtd_android:id/infoMessage"),
//                "Не найден эллемент статуса заказа",
//                15);
//
//        waitForElemAndClick(By.id("com.mvideo.rtd_android:id/dialogOk"),
//                "Не найдена кнопа ОК",
//                5);
//
//
//        System.out.println("- Тест пройден успешно!");
//    }
//
//
//    //Методы
//
//
//    private WebElement waitForElem(By by, String error_message, long timeOutInSec)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
//        wait.withMessage(error_message + "/n");
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//
//
//    private WebElement waitForElemAndClick(By by, String error_message, long timeOutInSec)
//    {
//        WebElement element = waitForElem(by, error_message, timeOutInSec);
//        element.click();
//        return element;
//    }
//
//
//
//    private WebElement waitForElemByAndSendKeys(By by, String value, String error_message, long timeOutInSec)
//    {
//        WebElement element = waitForElem(by, error_message, timeOutInSec);
//        element.sendKeys(value);
//        return element;
//    }
//
//
//
//    private WebElement waitForElemAndClear(By by, String error_message, long timeOutInSec)
//    {
//        WebElement element = waitForElem(by, error_message, timeOutInSec);
//        element.clear();
//        return element;
//    }
//
//
//
//    private boolean waitForElemNotPresent(By by, String error_message, long timeOutInSec)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
//        wait.withMessage(error_message + "/n");
//        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//    }
//
//
//
//    private WebElement assertElementHasText(By by, String value, String assert_error_message, String error_message, long timeOutInSec)
//    {
//        WebElement element = waitForElem(by, error_message, timeOutInSec);
//        String textValue = element.getAttribute("text");
//        Assert.assertEquals(assert_error_message,
//                value,
//                textValue);
//        return element;
//    }
//
//    protected void swipeUp(int timeOfSwipe)
//    {
//        TouchAction action = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();
//        int x = size.width/2;
//        int start_y = (int)(size.height * 0.8);
//        int end_y = (int)(size.height * 0.4);
//        action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release();
//    }
//
//}
