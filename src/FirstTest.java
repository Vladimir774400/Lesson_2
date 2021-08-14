import lib.CoreTestCase;
import lib.ui.cancelSearch;
import lib.ui.SearchPageObject;
import lib.ui.mainPageObject;
import lib.ui.saveArticles;
import org.junit.Test;
import org.openqa.selenium.By;


public class FirstTest extends CoreTestCase {
    private mainPageObject mainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        mainPageObject = new mainPageObject(driver);

    }

    @Test
    public void testEx3 ()
    {
        mainPageObject.prepareScreenOrientation();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Java");
        cancelSearch cancelSearch = new cancelSearch(driver);
        cancelSearch.waitForNumberOfResultsPresent();
        cancelSearch.clearResults();
        cancelSearch.checkElementsCleared();
        System.out.println("- Тест пройден успешно!");
    }

    @Test
    public void testEx5 ()
    {
        mainPageObject.prepareScreenOrientation();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Java");
        saveArticles saveArticles = new saveArticles(driver);
        saveArticles.waitForFirstArticlePresentSaveAndExitToMainPage();
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Dzigurda");
        saveArticles.waitForSecondArticlePresentSaveAndExitToMainPage();
        saveArticles.openSavedArticlesAndDeleteOne();
        saveArticles.confirmSecondAndCheckTitle();
        System.out.println("- Тест пройден успешно!");
    }

    @Test
    public void testEx6 ()
    {
        mainPageObject.prepareScreenOrientation();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResultAndClick("Java (programming language");
        mainPageObject.assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"),"Элемент не найден по id");
        System.out.println("- Тест пройден успешно!");
    }
}
