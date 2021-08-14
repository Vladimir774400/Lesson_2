package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends mainPageObject {
    private static final String
        SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text,'Search…')]",
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
        SEARCH_RESULT = "//*[contains(@text,'{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT.replace("{SUBSTRING}",substring);
    }
    public void searchInit()
    {
        this.waitForElemAndClick(By.xpath(SEARCH_INIT_ELEMENT), "НЕ МОГУ НАЙТИ ЭЛЕМЕНТ ПОЛЯ ВВОДА", 10);
        this.waitForElem(By.xpath(SEARCH_INPUT), "НЕ МОГУ НАЙТИ ПОЛЕ ВВОДА", 10);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElemByAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Не могу найти вводимое слово в сторку поиска",5);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElem(By.xpath(search_result_xpath), "Не могу найти результат поиска "+ substring, 10);
    }
    public void waitForSearchResultAndClick(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElemAndClick(By.xpath(search_result_xpath), "Не могу кликнуть результат поиска "+ substring, 10);
    }
}
