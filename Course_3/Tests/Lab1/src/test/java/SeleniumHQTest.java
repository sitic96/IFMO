package test.java;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

/**
 * Created by sitora on 10.04.17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumHQTest {
    private static WebDriver driver;
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

    @Test
    public void login() {
        driver.findElement(By.id("login-username")).sendKeys("redastify");
        driver.findElement(By.id("login-signin")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd"))).sendKeys("5878213r");
        driver.findElement(By.id("login-signin")).click();
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
                ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-compose"))).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("to-field"))).sendKeys("wersa2002@gmail.com");
        driver.findElement(By.id("subject-field")).sendKeys("Hello World!");
        driver.findElement(By.id("yui_3_16_0_ym19_1_1492162490360_3843")).sendKeys("Hi!");
    }

//    @Test
//    public void writeEmail() {
//        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.findElement(By.xpath("//a[@class='ns-view-toolbar-button-compose-go ns-view-id-94 js-toolbar-button mail-Toolbar-Item mail-Toolbar-Item_compose-go js-toolbar-item-compose-go js-toolbar-item']")) != null;
//            }
//        });
//
//        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//        wait.until(new Function<WebDriver, Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return String
//                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
//                        .equals("complete");
//            }
//        });
//
//        WebElement writeButton = driver.findElement(By.xpath("//a[@class='ns-view-toolbar-button-compose-go ns-view-id-94 js-toolbar-button mail-Toolbar-Item mail-Toolbar-Item_compose-go js-toolbar-item-compose-go js-toolbar-item']"));
//        writeButton.click();

//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.findElement(By.xpath("//div[@class='mail-Compose-Field-Input']")) != null;
//            }
//        });
    //driver.findElement(By.xpath("//div[@class='mail-Compose-Field-Input']")).click();
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementsByClassName('js-suggest-proxy _init ui-autocomplete-input')[0].setAttribute('type', 'text');");
//        driver.findElement(By.xpath("//div[@class='js-compose-field mail-Bubbles']")).click();


//        WebElement to = driver.findElement(By.xpath("//div[@class='js-compose-field mail-Bubbles']"));
//        to.click();
//        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("selenium");
//            }
//        });
//    }

//    @Test
//    public void loginExist() {
//        driver.findElement(By.id("login"));
//    }
//
//    @Test
//    public void passwordFieldExist() {
//        driver.findElement(By.id("passwd"));
//    }
//
//    @Test
//    public void submitExist() {
//        driver.findElement(By.xpath("//button[@class=' nb-button _nb-action-button js-submit-button domik-submit-button nb-group-start']"));
//    }
//
//    @Test
//    public void dontRememberPasswordExist() {
//        driver.findElement(By.xpath("//button[@class='pseudo-button_small pseudo-button_remember']"));
//    }
//
////    @Test
////    public void dontRememberPassword() {
////        WebElement remember = driver.findElement(By.xpath("//a[@class='pseudo-button_small pseudo-button_remember']"));
////        remember.click();
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        Assert.assertTrue(driver.getCurrentUrl().equals(remindPasswordUrl));
////    }
////
////    @Test
////    public void registrate() {
////        WebElement remember = driver.findElement(By.xpath("//a[@class='pseudo-button_small pseudo-button_register']"));
////        remember.click();
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        Assert.assertTrue(driver.getCurrentUrl().equals(registrationUrl));
////    }
////
////    @Test
////    public void helpClick() {
////        WebElement remember = driver.findElement(By.xpath("//a[@class='footer-link']"));
////        remember.click();
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        System.out.println(driver.getCurrentUrl());
////        Assert.assertTrue(driver.getCurrentUrl().equals(helpUrl));
////    }
//
//    @Test
//    public void testLoginWithEmptyFields() {
//        final String _currentUrl = driver.getCurrentUrl();
//        WebElement element = driver.findElement(By.xpath("//button[@class=' nb-button _nb-action-button js-submit-button domik-submit-button nb-group-start']"));
//        element.submit();
//
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Assert.assertTrue(_currentUrl.equals(driver.getCurrentUrl()));
//        System.out.println(driver.getCurrentUrl());
//
//    }
//
//    @Test
//    public void testIncorrectData() {
//        WebElement login = driver.findElement(By.id("login"));
//        WebElement password = driver.findElement(By.id("passwd"));
//        WebElement submit = driver.findElement(By.xpath("//button[@class=' nb-button _nb-action-button js-submit-button domik-submit-button nb-group-start']"));
//        login.sendKeys("lab1guliamova");
//        password.sendKeys("world");
//        submit.submit();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        /**
//         * При отсутствие ошибки, элемент не будет найден
//         */
//        driver.findElement(By.xpath("//div[@class='error-isle js-error-isle']"));
//    }
//
//    @Test
//    public void testCorrectLoginWithIncorrectPassword() {
//        WebElement login = driver.findElement(By.id("login"));
//        WebElement password = driver.findElement(By.id("passwd"));
//        WebElement submit = driver.findElement(By.xpath("//button[@class=' nb-button _nb-action-button js-submit-button domik-submit-button nb-group-start']"));
//        login.sendKeys("hello");
//        password.sendKeys("world");
//        submit.submit();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebElement errorDiv = driver.findElement(By.xpath("//div[@class='error-msg']"));
//        Assert.assertTrue(errorDiv.getText().equals("Неправильный логин или пароль."));
//    }
}