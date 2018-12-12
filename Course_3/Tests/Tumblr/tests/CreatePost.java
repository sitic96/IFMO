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
    public void createPost() throws InterruptedException {
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='compose-button']"))).click();

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='post-type-icon icon-text']"))).click();

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("My post");

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-richtext']"))).sendKeys("Hello world!");

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys("/Users/mac/Desktop/w_eb191985.jpg");


        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='button-area create_post_button']"))).click();

        //new WebDriverWait(driver, 50).until(
          //      ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='button-area csdfeate_post_button']"))).click();

    }

    @Test
    public void createTextOnly() {
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("new_post_label_text"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("My post");

        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-richtext']"))).sendKeys("Hello world!");
        driver.findElement(By.cssSelector("button[class='tx-button']")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ui_button btn_1 chrome blue']"))).click();

    }

    @Test
    public void createQuote() {
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("new_post_label_quote"))).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("I HATE TESTING");
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-richtext']"))).sendKeys("KALININ DENIS P3317");
        driver.findElement(By.cssSelector("button[class='tx-button']")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ui_button btn_1 chrome blue']"))).click();
    }

    @Test
    public void createLink() {
        driver.findElement(By.id("new_post_label_link")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("iam.ifmo.ru");
        driver.findElement(By.cssSelector("button[class='tx-button']")).click();
    }

    @Test
    public void createChat() {
        driver.findElement(By.id("new_post_label_chat")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='tx-button']"))).click();
    }

    @Test
    public void createAudio() {
        driver.findElement(By.id("new_post_label_audio")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='editor editor-plaintext']"))).sendKeys("Where is the love");
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-href='spotify:track:3CNqo3gYrfexdrtjFmC9he']"))).click();
        driver.findElement(By.cssSelector("button[class='tx-button']")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ui_button btn_1 chrome blue']"))).click();
    }
}
