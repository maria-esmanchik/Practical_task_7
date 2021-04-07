package org.example.service;

import org.example.data.Account;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationService {
    public static RegistrationPage registrationAccount(WebDriver driver, Account account) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open()
                .inputFirstName(account.getFirstName())
                .inputLastName(account.getLastName())
                .inputEmailValue(account.getEmail())
                .inputTelephoneValue(account.getTelephone())
                .inputPasswordValue(account.getPassword())
                .inputConfirmPasswordValue(account.getPassword())
                .clickNewsletterSubscribeValue()
                .clickCheckBoxPrivacy()
                .clickContinueButton();
        return registrationPage;
    }

    public static RegistrationPage registrationCheckBoxAccount(WebDriver driver, Account account) {
        RegistrationPage registrationCheckBoxPage = new RegistrationPage(driver);
        registrationCheckBoxPage.open()
                .inputFirstName(account.getFirstName())
                .inputLastName(account.getLastName())
                .inputEmailValue(account.getEmail())
                .inputTelephoneValue(account.getTelephone())
                .inputPasswordValue(account.getPassword())
                .inputConfirmPasswordValue(account.getPassword())
                .clickNewsletterSubscribeValue()
                .clickContinueButton();
        return registrationCheckBoxPage;
    }
}
