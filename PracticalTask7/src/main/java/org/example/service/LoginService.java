package org.example.service;

import org.example.data.Account;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {
    public static LoginPage loginAccount(WebDriver driver, Account account) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                    .inputEmailValue(account.getEmail())
                    .inputPasswordValue(account.getPassword())
                    .clickLoginButton();
        return loginPage;
    }
}
