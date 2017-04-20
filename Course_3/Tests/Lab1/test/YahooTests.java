import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by sitora on 10.04.17.
 */
public class YahooTests {
    private static boolean isLogin = false;
    protected static WebDriver driver;
    private static String url;

    @BeforeClass
    public static void setParams() {
        System.setProperty("webdriver.gecko.driver", "/users/mac/downloads/geckodriver");
        driver = new FirefoxDriver();
        url = "https://mail.yahoo.com/";
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

}