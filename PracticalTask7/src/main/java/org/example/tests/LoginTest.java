package org.example.tests;

import org.example.data.Account;
import org.example.pages.LoginPage;
import org.example.pages.MyAccountPage;
import org.example.service.LoginService;
import org.example.service.LogoutService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    private static WebDriver driver = null;

    private final String EMAIL = "login@login.com";
    private final String PASSWORD = "password123";
    private final String INVALID_PASSWORD = "123";
    String titleValue = null;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test()
    public void loginToMailTest() {
        titleValue = LoginService.loginAccount(driver, new Account(EMAIL, PASSWORD)).getTitleLoginValue();

        Assert.assertEquals(titleValue, LoginPage.PAGE_TITLE_TEXT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void loginToMailLogOutTest() {
        LoginService.loginAccount(driver, new Account(EMAIL, PASSWORD));
        titleValue = LogoutService.logoutAccount(driver).getTitleLogoutValue();

        Assert.assertEquals(titleValue, MyAccountPage.TEXT_LOCATOR_LOGOUT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void loginToMailInvalidTest() {
        titleValue = LoginService.loginAccount(driver, new Account(EMAIL, INVALID_PASSWORD)).getTitleInvalidPasswordValue();

        Assert.assertEquals(titleValue, LoginPage.TEXT_LOCATOR_INVALID_PASSWORD, "Testing of logging with valid data is failed");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
