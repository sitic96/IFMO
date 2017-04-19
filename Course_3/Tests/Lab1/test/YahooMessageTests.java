import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sitora on 18.04.17.
 */
public class YahooMessageTests extends YahooTests {
    private static List<String> fonts, sizes;
    private static WebDriver driver;
    private static boolean isSetUp = false;

    static {
        fonts = new ArrayList<String>();
        sizes = new ArrayList<String>();

        fonts.add("font-family: HelveticaNeue, Helvetica Neue, Helvetica, Arial, Lucida Grande, sans-serif;");
        fonts.add("font-family: verdana, helvetica, sans-serif;");
        fonts.add("font-family: times new roman, new york, times, serif;");
        fonts.add("font-family: bookman old style, new york, times, serif;");
        fonts.add("font-family: Courier New, courier, monaco, monospace, sans-serif;");
        fonts.add("font-family: garamond, new york, times, serif;");
        fonts.add("font-family: lucida console, sans-serif;");

        sizes.add("font-size:10px;");
        sizes.add("font-size:13px;");
        sizes.add("font-size:16px;");
        sizes.add("font-size:24px;");
        sizes.add("font-size:32px;");
        sizes.add("font-size:48px;");
    }

    @Before
    public void init() {
        System.out.println("Login");
        if (isSetUp) {
            System.out.println("True");
            return;
        } else {
            super.login();
            System.out.println("False");
            this.driver = super.driver;
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-compose']"))).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='btn default']")));
            isSetUp = true;
        }
    }

    @Test
    public void fillInformation() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("to-field"))).sendKeys("wersa2002@gmail.com");
        driver.findElement(By.id("subject-field")).sendKeys("Hello World!");
    }

    @Test
    public void changeFonts() {
        driver.findElement(By.id("btn-fontnamesize")).click();
        for (int i = 0; i < fonts.size(); i++) {
            driver.findElement(By.xpath("//span[@style='" + fonts.get(i) + "']")).click();
            for (int j = 0; j < sizes.size(); j++) {
                driver.findElement(By.id("btn-fontnamesize")).click();
                driver.findElement(By.xpath("//span[@style='" + sizes.get(j) + "']")).click();
                driver.findElement(By.id("rtetext")).sendKeys("Hi!");
            }
            driver.findElement(By.id("rtetext")).sendKeys("\r\n");
            driver.findElement(By.id("btn-fontnamesize")).click();
        }
        driver.findElement(By.xpath("//span[@class='icon icon-bold btnpress']")).click();
        driver.findElement(By.id("rtetext")).sendKeys("Bold! \r\n");
        driver.findElement(By.xpath("//span[@class='icon icon-italic btnpress']")).click();
        driver.findElement(By.id("rtetext")).sendKeys("Italic! \r\n");
    }

    @Test
    public void changeViewToList() {
        driver.findElement(By.id("btn-insertunordered")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-list-bullets']")).click();
        driver.findElement(By.id("btn-insertunordered")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-list-numbers']")).click();
    }

    @Test
    public void changeIndent() {
        driver.findElement(By.id("btn-indent")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-indent']")).click();
        driver.findElement(By.id("btn-indent")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-outdent']")).click();
    }

    @Test
    public void changeAlign() {
        driver.findElement(By.id("btn-text-align")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-align-left']")).click();
        driver.findElement(By.id("btn-text-align")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-align-center']")).click();
        driver.findElement(By.id("btn-text-align")).click();
        driver.findElement(By.xpath("//i[@class='icon icon-align-right']")).click();
    }

    @Test
    public void addLink() {
        driver.findElement(By.xpath("//span[@class='icon icon-link']")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("newDescription"))).sendKeys("Hello");
        driver.findElement(By.id("newURL")).sendKeys("google.com");
        driver.findElement(By.id("okayModalOverlay")).click();
    }

    @Test
    public void cancelNewLink() {
        driver.findElement(By.xpath("//span[@class='icon icon-link']")).click();
        driver.findElement(By.id("cancelModalOverlay")).click();
    }

    @Test
    public void addEmoji() {
        driver.findElement(By.id("emoticon")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='emoticon_5']"))).click();
        driver.findElement(By.id("emoticon")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='emoticon_35']"))).click();
    }

    public void hidePanel() {
        //Hide/Show panel
        driver.findElement(By.id("switchtext-rich")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("cancelModalOverlay"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("switchtext-rich"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("okayModalOverlay"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("switchtext-plain"))).click();
    }
}
