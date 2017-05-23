import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTests extends BasicTest {
    private boolean isSetUp = false;

    @Before
    public void init() {
        if (!isSetUp) {
            super.login();
        }
    }

    @Test
    public void search() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search_query"))).sendKeys("Selenium" + Keys.ENTER);
    }

    @Test
    public void topPanelTests() {
        //Recommended
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='recommended-for-you']"))).click();

        //Trending
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='trending']"))).click();

//        //Staff picks
//        new WebDriverWait(driver, 15).until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[data-content-type='staff-picks']"))).click();
//
//        //Text
//        new WebDriverWait(driver, 15).until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[data-content-type='text']"))).click();
//
//        //Photos
//        new WebDriverWait(driver, 15).until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[data-content-type='photos']"))).click();
//
//        //Gifs
//        new WebDriverWait(driver, 15).until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[data-content-type='gifs']"))).click();
//
//        //Quotes
//        new WebDriverWait(driver, 15).until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[data-content-type='quotes']"))).click();
    }
}