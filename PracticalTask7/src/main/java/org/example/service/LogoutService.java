package org.example.service;

import org.example.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;

public class LogoutService {
    public static MyAccountPage logoutAccount(WebDriver driver) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.open()
                .clickMyAccountButton()
                .clickLogoutButton();
        return myAccountPage;
    }
}
