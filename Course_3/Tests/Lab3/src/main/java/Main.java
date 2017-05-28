import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    protected AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Clone - Google Nexus 10 - 4.3 - API 18 - 2560x1600");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.3");
        File path = new File("vkontakte.android-4_8_3.apk");
        capabilities.setCapability(MobileCapabilityType.APP, path.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.vkontakte.android");
        capabilities.setCapability("appActivity", "com.vkontakte.android.MainActivity");
        try {
            //Install
            Runtime.getRuntime().exec("adb install " + path.getAbsolutePath());
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            //Login
            driver.findElement(By.id("com.vkontakte.android:id/auth_root")).sendKeys("login");
            driver.findElement(By.id("com.vkontakte.android:id/auth_pass")).sendKeys("password");
            driver.findElement(By.id("com.vkontakte.android:id/auth_login_btn")).click();

            //Create post
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/fl_create_post"))).click();
            driver.findElement(By.id("com.vkontakte.android:id/status_text_edit")).sendKeys("HELLO WORLD!");
            driver.findElement(By.id("com.vkontakte.android:id/newpost_btn_settings")).click();
            driver.findElement(By.id("android:id/text1")).click();
            driver.findElement(By.id("android:id/button1")).click();
            driver.findElement(By.id("com.vkontakte.android:id/done")).click();

            //Search
            driver.findElement(By.id("com.vkontakte.android:id/search2")).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/query"))).sendKeys("Sorokin");
            driver.findElement(By.id("com.vkontakte.android:id/title")).click();
            driver.findElement(By.id("com.vkontakte.android:id/text")).click();

            //Music
            Thread.sleep(1500);
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 9 + "']"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='" + "Recommendations" + "']"))).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='" + "My music" + "']"));
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='" + "Swish Swish (feat. Nicki Minaj)" + "']"))).click();

            //Status
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 0 + "']"))).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 3 + "']"))).click();
            driver.findElement(By.id("com.vkontakte.android:id/text")).click();
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='" + 1 + "']"))).sendKeys("Hello World!");
            driver.findElement(By.id("android:id/button1")).click();

            //Logout
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='" + 1 + "']"))).click();
            //com.vkontakte.android:id/writebar_edit
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/writebar_edit"))).sendKeys("Cool!");
            driver.findElement(By.id("com.vkontakte.android:id/writebar_send")).click();

        } catch (IOException e) {

        }
    }
}
