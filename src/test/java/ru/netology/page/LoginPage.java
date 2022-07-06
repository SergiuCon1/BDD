package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorPopupLogin = $("[data-test-id=\"error-notification\"] .notification__content");

    private SelenideElement loginInputInvalid = $("[data-test-id=\"login\"].input_invalid .input__sub");
    private SelenideElement passwordInputInvalid = $("[data-test-id=\"password\"].input_invalid .input__sub");


    public VerificationPage validLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
        return new VerificationPage();
    }

    public void invalidLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void verifyInvalidLogin() {
        errorPopupLogin.shouldHave(text("Неверно указан логин или пароль"));
    }
}
