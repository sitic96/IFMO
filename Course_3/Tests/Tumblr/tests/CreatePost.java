import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreatePost extends BasicTest {
    private boolean isSetUp = false;

    @Before
    public void init() {
        if (!isSetUp) {
            super.login();
        }
    }

    @Test
    public void createPost() {
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='compose-button']"))).click();

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='post-type-icon icon-text']"))).click();

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("My post");

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-richtext']"))).sendKeys("Hello world!");

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys("/Users/mac/Desktop/w_eb191985.jpg");

        // driver.findElement(By.cssSelector("div[class='control add-inline-embed']")).click();
        //driver.findElement(By.cssSelector("div[class='editor editor-richtext']")).sendKeys("https://www.youtube.com/watch?v=Z8lUW9SKquY");

        driver.findElement(By.cssSelector("button[class='tx-button']")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ui_button btn_1 chrome blue']"))).click();
    }

}
