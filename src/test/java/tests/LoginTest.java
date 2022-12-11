package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pajeobject.LoginPage;
import pajeobject.MainPage;
import pajeobject.PasswordRecoveryPage;
import pajeobject.RegistrationPage;

import static constans.DataLogin.EMAIL;
import static constans.DataLogin.PASSWORD;


public class LoginTest extends BaseTest{

    MainPage mainPage;
    RegistrationPage registrationPage;

    PasswordRecoveryPage passwordRecoveryPage;
    LoginPage loginPage;
    @After
    public void end() {
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.setEmailForLogin(EMAIL);
        loginPage.setPasswordForLogin(PASSWORD);
        loginPage.clickEnter();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitButtonForMakeOrder();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }
    @Test
    @DisplayName("Вход в приложение по кнопке «Войти в аккаунт» на главной странице")
    public void clickLogInOnMainPageUserLoggedIn() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.clickSignInButton();
    }

    @Test
    @DisplayName("Вход в приложение через кнопку «Личный кабинет»  на главной странице")
    public void clickPersonalAccountButtonOnMainPageUserLoggedIn() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.clickPersonalAccount();
    }

    @Test
    @DisplayName("Вход в приложение через кнопку Войти (Уже зарегестрированы?) на форме регистрации")
    public void clickSignInLinkOnRegistrationPageUserLoggedIn() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());
        registrationPage.clickSignIn();
    }

    @Test
    @DisplayName("Вход в приложение через кнопку Войти (Вспомнили пароль?) на странице восстановления пароля")
    public void clickSignInLinkOnPasswordRecoveryPageUserLoggedIn() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        PageFactory.initElements(driver, passwordRecoveryPage);
        driver.get(passwordRecoveryPage.getCurrentUrl());
        passwordRecoveryPage.signIn();
    }
}
