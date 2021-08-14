package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class saveArticles extends mainPageObject{

    public static final String
            ARTICLE1_CONTAINS_TEXT = "//*[contains(@text,'Java (programming language')]",
            ARTICLE2_CONTAINS_TEXT = "//*[contains(@text,'Nikita Dzhigurda')]",
            SAVE_ELEMENT = "//*[@class='android.support.v7.app.ActionBar$Tab']",
            CLOSE_BTTN = "//*[@content-desc='Navigate up']";

    public saveArticles(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForFirstArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(By.xpath(ARTICLE1_CONTAINS_TEXT), "Элемент не найден",
                15);
        this.waitForElemAndClick(By.xpath(SAVE_ELEMENT),
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(By.id("org.wikipedia:id/onboarding_button"),
                "Кнопка онбординга Got It не найдена",
                10);
        this.waitForElemAndClear( By.id("org.wikipedia:id/text_input"),
                "Обьект 'Имя листа' не отображается в течении 5 секунд",
                5);
        this.waitForElemByAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "New list",
                "Обьект 'Имя листа' не отображается в течении 5 секунд",
                5);
        this.waitForElemAndClick(By.id("android:id/button1"),
                "Элемент кнопки ОК не найден",
                15);
        this.waitForElemAndClick(By.xpath(CLOSE_BTTN),"Элемент X не найден", 10);
    }

    public void waitForSecondArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(By.xpath(ARTICLE2_CONTAINS_TEXT), "Элемент не найден",
                15);
        this.waitForElemAndClick(By.xpath(SAVE_ELEMENT),
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(By.xpath("//*[contains(@text,'New list')]"),
                "New list не найден",
                10);
        this.waitForElemAndClick(By.xpath(CLOSE_BTTN),"Элемент X не найден", 10);
    }

    public void openSavedArticlesAndDeleteOne()
    {
        this.waitForElemAndClick(By.xpath("//*[@content-desc='My lists']"),
                "Кнопка сохраненных статей не найдена",
                10);
        this.waitForElemAndClick(By.id("org.wikipedia:id/item_title"),
                "New list не найден",
                10);
        this.swipeElementLeft(By.xpath(ARTICLE1_CONTAINS_TEXT), "Статья не свайпается");

    }

    public void confirmSecondAndCheckTitle()
    {
        waitForElemAndClick(By.id("org.wikipedia:id/page_list_item_title"),"Вторая статья не найдена", 10);
        waitForElem(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text' and @text='Nikita Dzhigurda']"),
                "Заголовок статьи не совпадает",
                15);
    }

}
