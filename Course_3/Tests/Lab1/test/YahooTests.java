import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sitora on 10.04.17.
 */
public class YahooTests {
    private static List<String> fonts, sizes;
    private static boolean isLogin = false;
    private static WebDriver driver;
    private static String url;

    @BeforeClass
    public static void setParams() {
        System.setProperty("webdriver.gecko.driver", "/users/mac/downloads/geckodriver");
        driver = new FirefoxDriver();
        url = "https://mail.yahoo.com/";

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

        driver.navigate().to(url);
    }

    @AfterClass
    public static void closeWindow() {
        driver.quit();
    }

    @Before
    public void login() {
        if (isLogin) {
            return;
        } else {
            driver.findElement(By.id("login-username")).sendKeys("redastify");
            driver.findElement(By.id("login-signin")).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd"))).sendKeys("my_password");
            driver.findElement(By.id("login-signin")).click();
            isLogin = true;

        }
    }

    @Test
    public void searchMail() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='typeahead-input typeahead-input-usertext']"))).sendKeys("hello");
        driver.findElement(By.id("mail-search-btn")).click();
    }

    @Test
    public void writeEmail() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-compose']"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("to-field"))).sendKeys("wersa2002@gmail.com");
        driver.findElement(By.id("subject-field")).sendKeys("Hello World!");
        driver.findElement(By.id("rtetext")).sendKeys("Hi! I'm testing you!");

        editEmail();
    }

    public void editEmail() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("btn-fontnamesize"))).click();

        for (int i = 0; i < fonts.size(); i++) {
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@style='" + fonts.get(i) + "']"))).click();
            for (int j = 0; j < sizes.size(); j++) {
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("btn-fontnamesize"))).click();
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@style='" + sizes.get(j) + "']"))).click();

                driver.findElement(By.id("rtetext")).sendKeys("This is new style! ");
            }
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("btn-fontnamesize"))).click();
        }
    }
}