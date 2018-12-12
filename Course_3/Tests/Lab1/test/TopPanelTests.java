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
    private static boolean isSetUp = false;

    static {
        LIST_SELECT_OPTIONS = new HashSet<String>();
        LIST_SELECT_OPTIONS.add("all");
        LIST_SELECT_OPTIONS.add("none");
        LIST_SELECT_OPTIONS.add("unRead");
        LIST_SELECT_OPTIONS.add("Read");
        LIST_SELECT_OPTIONS.add("Flagged");
        LIST_SELECT_OPTIONS.add("unFlagged");
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

    @Test
    public void selectAll() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("btn-select-dd"))).click();

        for (String option : LIST_SELECT_OPTIONS) {
            try {
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='" + option + "']"))).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.findElement(By.id("btn-select-dd")).click();
        }
    }

    @Test
    public void archive(){
        driver.findElement(By.id("btn-archive")).click();
    }

    @Test
    public void move(){
        //inbox-move
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("btn-select-dd"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='Read']"))).click();
        driver.findElement(By.id("btn-move")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='folder-menu-create-span']"))).click();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='folder-menu-input focus-node']"))).sendKeys("My folder");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}