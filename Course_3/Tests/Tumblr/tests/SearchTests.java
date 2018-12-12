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
    public void anotherSearch() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search_query"))).sendKeys("Glee" + Keys.ENTER);
    }

    /**
     * Don't run without search
     */
    @Test
    public void topPanelTests() throws InterruptedException {
        //Recommended
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='recommended-for-you']"))).click();
        wait2Seconds();
        //Trending
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='trending']"))).click();
        wait2Seconds();
        //Staff picks
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='staff-picks']"))).click();
        wait2Seconds();
        //Text
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='text']"))).click();
        wait2Seconds();
        //Photos
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='photos']"))).click();
        wait2Seconds();
        //Gifs
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='gifs']"))).click();
        wait2Seconds();
        //Quotes
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-content-type='quotes']"))).click();
    }

    public void wait2Seconds() throws InterruptedException {
        Thread.sleep(2000);
    }
}