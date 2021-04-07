package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private final String pageAddress = "http://electonicstore.com/index.php?route=account/account";

    private By myAccount = By.xpath("//span[contains(text(), 'My Account')]");

    private By logoutButton = By.xpath("//a[@href='http://electonicstore.com/index.php?route=account/logout']");

    public static final String TEXT_LOCATOR_LOGOUT = "Account Logout";
    private By logOutValue = By.xpath("//div[@id='content']/h1");

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {

        this.driver = driver;
    }

    public MyAccountPage open() {
        driver.get(pageAddress);
        return this;
    }
    public MyAccountPage clickMyAccountButton() {
        driver.findElement(myAccount).click();
        return this;
    }

    public MyAccountPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;
    }

    public String getTitleLogoutValue() {
        String titleLogoutTest = driver.findElement(logOutValue).getText();
        return titleLogoutTest;
    }
}
