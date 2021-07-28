import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xpath.SourceTree;
import org.apache.xpath.operations.Bool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

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


        String searchRequest = "java";

        waitForElemByAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                searchRequest,
                "Обьект 'Search Wikipedia' не отображается в течении 5 секунд",
                5);

        waitForElemAndClick(By.xpath("//*[contains(@text,'Java (programming language')]"),
                "Элемент не найден",
                15);

        waitForElemAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
                "Элемент сохранения не найден",
                15);

        waitForElemAndClick(By.id("org.wikipedia:id/snackbar_action"),
                "Элемент добавления не найден",
                15);

        waitForElemByAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "New list",
                "Обьект 'Имя листа' не отображается в течении 5 секунд",
                5);

        waitForElemAndClick(By.id("android:id/button1"),
                "Элемент кнопки ОК не найден",
                15);

        waitForElemAndClick(By.xpath("//*[@content-desc='Navigate up']"),
                "Элемент кнопки Назад не найден",
                15);

        waitForElemAndClick(By.xpath("//*[contains(@text,'JavaScript')]"),
                "Элемент не найден",
                15);

        waitForElemAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
                "Элемент сохранения не найден",
                15);

        waitForElemAndClick(By.id("org.wikipedia:id/snackbar_action"),
                "Элемент добавления не найден",
                15);

        waitForElemAndClick(By.xpath("//*[contains(@text,'New list')]"),
                "Элемент New list не найден",
                15);

        waitForElemAndClick(By.id("org.wikipedia:id/snackbar_action"),
                "Элемент добавления не найден",
                15);

        swipeElementLeft(By.xpath("//*[contains(@text,'JavaScript')]"),
                "Элемент не свайпается или не удаляется");


        waitForElemAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
                "Статья 'Java (programming language)' не найдена в листе",
                15);

        waitForElem(By.xpath("//*[@content-desc='Java (programming language)']"),
                "Заголовок статьи не совпадает",
                15);

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

    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int)(size.height * 0.8);
        int end_y = (int)(size.height * 0.2);
         action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    protected void swipeUpFast()
    {
        swipeUp(200);
    }

    protected void swipeUpTillFindElem(By by, String error_message, int max_swipes)
    {
        int alreadySwiped = 0;
        while (driver.findElements(by).size()==0)
        {
            if (alreadySwiped>max_swipes)
            {
                waitForElem(by,"Не могу найти элемента в процессе скролла вниз. \n" + error_message , 0);
                return;
            }

            swipeUpFast();
            ++alreadySwiped;
        }
    }

    protected void swipeElementLeft(By by, String error_message)
    {
        WebElement element = waitForElem(by,error_message,10);
        Dimension size = driver.manage().window().getSize();
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle = (upper_y+lower_y)/2;
        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle)
                .waitAction(400)
                .moveTo(left_x,middle)
                .release()
                .perform();
    }

    private int getAmountOfElem(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();

    }

    private void assertElemNotPresent (By by, String error_message)
    {
        int amount_of_elements = getAmountOfElem(by);
        if (amount_of_elements > 0){
            String default_message = "Элемент '"+ by.toString() + "' не появился";
            throw new AssertionError(default_message + "" + error_message);
        }
    }

    private String waitForElementAndGetAttribute (By by, String attribute, String error_message, long timeOut)
    {
        WebElement element = waitForElem(by, error_message, timeOut);
        return  element.getAttribute(attribute);
    }

}
