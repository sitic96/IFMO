import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;

/**
 * Created by sitora on 20.04.17.
 */
public class SearchTests extends YahooTests {
    private final static HashSet<String> LIST_OF_FOLDERS;
    private static boolean isSetUp = false;
    private WebDriver driver;

    static {
        LIST_OF_FOLDERS = new HashSet<String>();
        LIST_OF_FOLDERS.add("Inbox");
        LIST_OF_FOLDERS.add("Drafts");
        LIST_OF_FOLDERS.add("Sent");
        LIST_OF_FOLDERS.add("Archive");
        LIST_OF_FOLDERS.add("Trash");
    }

    @Before
    public void setUp() {
        if (isSetUp) {
            return;
        } else {
            super.login();
            this.driver = super.driver;
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("Inbox")));
            isSetUp = true;
        }
    }

    @Test
    public void selectWhere() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-value='All']"))).click();
        for (String folder : LIST_OF_FOLDERS) {
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-value='" + folder + "']"))).click();
            driver.findElement(By.xpath("//button[@class='search-menu-button right-folder-dd search-folder-scope-dd']")).click();

        }
    }

    @Test
    public void searchMail() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='typeahead-input typeahead-input-usertext']"))).sendKeys("hello");
        driver.findElement(By.id("mail-search-btn")).click();
    }
}
