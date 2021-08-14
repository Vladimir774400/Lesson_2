package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class mainPageObject {
    protected AppiumDriver driver;
    public mainPageObject (AppiumDriver driver)
    {
        this.driver = driver;
    }

    //Методы

    public void prepareScreenOrientation ()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void assertElementPresent (By by, String error_message)
    {
        Assert.assertTrue(error_message, driver.findElements(by).size()>0);
    }

    public WebElement waitForElem(By by, String error_message, long timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public WebElement waitForElemAndClick(By by, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        element.click();
        return element;
    }



    public WebElement waitForElemByAndSendKeys(By by, String value, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        element.sendKeys(value);
        return element;
    }



    public WebElement waitForElemAndClear(By by, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        element.clear();
        return element;
    }



    public boolean waitForElemNotPresent(By by, String error_message, long timeOutInSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



    public WebElement assertElementHasText(By by, String value, String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertEquals(assert_error_message,
                value,
                textValue);
        return element;
    }

    public WebElement assertElementContainsText(By by, String value,  String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(by, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertTrue(assert_error_message,textValue.contains(value));
        return element;
    }

    public void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int)(size.height * 0.8);
        int end_y = (int)(size.height * 0.2);
        action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    public void swipeUpFast()
    {
        swipeUp(200);
    }

    public void swipeUpTillFindElem(By by, String error_message, int max_swipes)
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

    public void swipeElementLeft(By by, String error_message)
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

    public int getAmountOfElem(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();

    }

    public void assertElemNotPresent (By by, String error_message)
    {
        int amount_of_elements = getAmountOfElem(by);
        if (amount_of_elements > 0){
            String default_message = "Элемент '"+ by.toString() + "' не появился";
            throw new AssertionError(default_message + "" + error_message);
        }
    }


    public String waitForElementAndGetAttribute (By by, String attribute, String error_message, long timeOut)
    {
        WebElement element = waitForElem(by, error_message, timeOut);
        return  element.getAttribute(attribute);
    }

}
