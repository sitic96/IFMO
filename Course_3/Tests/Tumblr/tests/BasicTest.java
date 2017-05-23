import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasicTest {
    private static boolean isLogin = false;
    protected static WebDriver driver;
    private static String url;

    @BeforeClass
    public static void setParams() {
        System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver");
        driver = new ChromeDriver();
        url = "https://www.tumblr.com/dashboard";
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
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("signup_determine_email"))).sendKeys("redastify@yahoo.com");

            driver.findElement(By.id("signup_forms_submit")).click();
            try {
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='orko-button-primary orko-buttonorko-button-primary orko-button']"))).click();
            } catch (Exception e) {

            }

            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-signin"))).click();
            //driver.findElement(By.id("login-signin")).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd"))).sendKeys("my_password");
            driver.findElement(By.id("login-signin")).click();
            isLogin = true;

        }
    }
}
