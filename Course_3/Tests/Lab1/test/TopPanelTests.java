import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;

/**
 * Created by sitora on 20.04.17.
 */
public class TopPanelTests extends YahooTests {
    private final static HashSet<String> LIST_SELECT_OPTIONS;
    private static boolean isSetUp = false, clicked = false;

    static {
        LIST_SELECT_OPTIONS = new HashSet<String>();
        LIST_SELECT_OPTIONS.add("all");
        LIST_SELECT_OPTIONS.add("none");
        LIST_SELECT_OPTIONS.add("unread");
        LIST_SELECT_OPTIONS.add("read");
        LIST_SELECT_OPTIONS.add("starred");
        LIST_SELECT_OPTIONS.add("unstarred");
    }

    @Before
    public void setUp() {
        if (isSetUp) {
            return;
        } else {
            super.login();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("Inbox")));
            isSetUp = true;
        }
    }

    @Before
    public void selectMessages() {
        if (!clicked) {
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Select or deselect all messages [Cmd+A]']"))).click();
            clicked = true;
        }
    }

    @Test
    public void selectAll(){
        driver.findElement(By.id("btn-select-dd")).click();

        for (String option:LIST_SELECT_OPTIONS){
            driver.findElement(By.xpath(""))
        }
    }
}