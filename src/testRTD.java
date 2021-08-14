//import io.appium.java_client.TouchAction;
//import lib.CoreTestRtd;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class testRTD extends CoreTestRtd {
//
//    @Test
//    public void testOrderStatusTest ()
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
//}
