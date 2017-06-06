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
 * Created by sitora on 04.06.17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Clone - Google Nexus 10 - 4.3 - API 18 - 2560x1600");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.3");
        File path = new File("com.facebook.katana_126.0.0.23.77-59956222_minAPI15(x86)(280,360,400,420,480,560,640dpi)_apkmirror.com.apk");
        capabilities.setCapability(MobileCapabilityType.APP, path.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.facebook.katana");
        capabilities.setCapability("appActivity", "com.facebook.katana.LoginActivity");
        try {
            //Install #1
            //Runtime.getRuntime().exec("adb install " + path.getAbsolutePath());
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            //Login #2
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/login_username"))).sendKeys("your_login");
            driver.findElement(By.id("com.facebook.katana:id/login_password")).sendKeys("password");
            driver.findElement(By.id("com.facebook.katana:id/login_login")).click();

            //Check Messages #3
            new WebDriverWait(driver, 50).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/primary_action_button"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/fb_logo_up_button"))).click();

            //Create status #4
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/feed_composer_status_button"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/composer_scrollable_content"))).sendKeys("Hello world!");
            driver.findElement(By.id("com.facebook.katana:id/selectable_privacy_pill_view")).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@index='" + 3 + "']"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/fb_logo_up_button"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/primary_named_button"))).click();

            //Open notifications #5
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/notifications_tab"))).click();

            //Open bookmarks
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/bookmarks_tab"))).click();

            //Open event
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/events_bookmark"))).click();

            //Show birthdays
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/filter_3"))).click();
            driver.findElement(By.id("com.facebook.katana:id/fb_logo_up_button")).click();

            //Open right menu #6
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.facebook.katana:id/secondary_action_button"))).click();


        } catch (IOException e) {

        }
    }
}
