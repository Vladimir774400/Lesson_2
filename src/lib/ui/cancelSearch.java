package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class cancelSearch extends mainPageObject{

    public static final String
            MORE_THAN_ONE_ARTICLES_PRESENT = "//*[@class='android.widget.TextView' and @instance='2']",
            MORE_THAN_ZERO_ARTICLES_PRESENT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']";

    public cancelSearch(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForNumberOfResultsPresent()
    {
        this.waitForElem(By.xpath(MORE_THAN_ONE_ARTICLES_PRESENT), "Результатов поиска нет или не более одного", 10);
    }

    public void clearResults()
    {
        this.waitForElemAndClear(By.id("org.wikipedia:id/search_src_text"), "Не могу очистить поле в течении 10 секунд", 10);
    }

    public void checkElementsCleared()
    {
        this.waitForElemNotPresent(By.xpath(MORE_THAN_ZERO_ARTICLES_PRESENT),"Результаты поиска по прежнему отображаются", 10);
    }

}
