import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by sitora on 15.06.17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Clone - Google Nexus 10 - 4.3 - API 18 - 2560x1600");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.3");
        File path = new File("askfm_v4.3.5548.apk");
        capabilities.setCapability(MobileCapabilityType.APP, path.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.askfm");
        capabilities.setCapability("appActivity", "com.askfm.welcome.WelcomeActivity");
        try {
            //Install
            //Runtime.getRuntime().exec("adb install " + path.getAbsolutePath());
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            //Login
            driver.findElement(By.id("com.askfm:id/loginLabel")).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/usernameInput"))).sendKeys("alink2001");
            driver.findElement(By.id("com.askfm:id/passwordInput")).sendKeys("5878213r");
            driver.findElement(By.id("com.askfm:id/buttonActionLogin")).click();

            //Ask someone
            new WebDriverWait(driver, 20).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/askQuestionTabIcon"))).click();
            driver.findElement(By.id("com.askfm:id/whoToAskHeadingImageButton")).click();

            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 1 + "']"))).click();
            driver.findElement(By.id("com.askfm:id/actionForward")).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/editTextQuestionComposer"))).sendKeys("How are you doing?");
            driver.findElement(By.id("com.askfm:id/actionQuestionAsk")).click();

            //Get a random question
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/inboxTabContainer"))).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/getRandomQuestionButton"))).click();

            //Answer
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 1 + "']"))).click();
            driver.findElement(By.id("com.askfm:id/editTextAnswerComposer")).sendKeys("My answer!");
            driver.findElement(By.id("com.askfm:id/actionAnswer")).click();

            //Click on buttons
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/inboxTabContainer"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/profileTabContainer"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.askfm:id/friendsTabContainer"))).click();

        } catch (IOException e) {

        }

    }
}
