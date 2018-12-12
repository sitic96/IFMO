import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuTests extends BasicTest {
    private boolean isSetUp = false;

    @Before
    public void init() {
        if (!isSetUp) {
            super.login();
        }
    }

    @Test
    public void menuTopTests() {
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("home_button"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("discover_button"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("inbox_button"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("messaging_button"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("activity_button"))).click();
        driver.findElement(By.id("activity_button")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("account_button"))).click();
        driver.findElement(By.id("account_button")).click();

    }

    @Test
    public void LeftMenuTests(){
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[href='/likes']"))).click();
    }
}
