package org.example.tests;

import org.example.data.Account;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.example.service.LoginService;
import org.example.service.RegistrationService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private static WebDriver driver = null;

    private final static String FIRST_NAME = "Mary";
    private static String LAST_NAME = "Poppins";
    private static String INVALID_EMAIL = "xzlk8@vmani.com";
    private static String TELEPHONE = "2515643465";
    private static String PASSWORD = "password123";
    private static long NUM = System.currentTimeMillis();
    private static String EMAIL = "login@login" + NUM +".com";
    String titleValue = null;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test()
    public void registrationToMailInvalidTest() {
        titleValue = RegistrationService.registrationAccount(driver, new Account(FIRST_NAME, LAST_NAME, INVALID_EMAIL,TELEPHONE, PASSWORD)).getTitleRegistrationInvalidEmailValue();

        Assert.assertEquals(titleValue, RegistrationPage.TEXT_INVALID_EMAIL, "Testing of logging with valid data is failed");
    }

    @Test()
    public void registrationToMailTest() {
        titleValue = RegistrationService.registrationAccount(driver, new Account(FIRST_NAME, LAST_NAME, EMAIL,TELEPHONE, PASSWORD)).getTitleRegistrationValue();

        Assert.assertEquals(titleValue, RegistrationPage.PAGE_TITLE_TEXT, "Testing of logging with valid data is failed");
    }

    @Test()
    public void registrationToMailCheckBoxTest() {
        titleValue = RegistrationService.registrationCheckBoxAccount(driver, new Account(FIRST_NAME, LAST_NAME, EMAIL,TELEPHONE, PASSWORD)).getTitleRegistrationCheckBoxValue();

        Assert.assertEquals(titleValue, RegistrationPage.TEXT_CHECK_BOX, "Testing of logging with valid data is failed");
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}
