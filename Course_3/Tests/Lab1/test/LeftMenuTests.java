import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sitora on 19.04.17.
 */
public class LeftMenuTests extends YahooTests {
    private static boolean isSetUp = false;
    private WebDriver driver;

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
    public void testInbox() {
       // driver.findElement(By.id("Inbox")).click();

        Actions act = new Actions(driver); // where driver is WebDriver type

        act.moveToElement(driver.findElement(By.id("Inbox")));

        act.contextClick(driver.findElement(By.id("Inbox"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mark emails as read')]"))).click();

        ////div[contains(text(),'noreply@somedomain.com')]
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fdghjgkh default']")));
    }
}
