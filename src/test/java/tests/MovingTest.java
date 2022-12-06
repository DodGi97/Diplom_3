package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pajeobject.AccountPage;
import pajeobject.LoginPage;
import pajeobject.MainPage;

import static constans.DataLogin.EMAIL;
import static constans.DataLogin.PASSWORD;

public class MovingTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    AccountPage accountPage;

    @Before
    public void startTest() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getCurrentUrl());
        mainPage.clickSignInButton();
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.setEmailForLogin(EMAIL);
        loginPage.setPasswordForLogin(PASSWORD);
        loginPage.clickEnter();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.clickPersonalAccount();

    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы")
    public void goToProfileFromMainPage() {
        accountPage = new AccountPage(driver);
        PageFactory.initElements(driver, accountPage);
        accountPage.waitForDisplayProfileText();
        Assert.assertEquals("Профиль", accountPage.getProfileText());
    }

    @Test
    @DisplayName("Переход на главную страницу нажав на Конструтор")
    public void goToMainPageFromProfileWithConstructor() {
        accountPage = new AccountPage(driver);
        PageFactory.initElements(driver, accountPage);
        accountPage.clickConstructor();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForDisplayMakeBurgerText();
        Assert.assertEquals("Соберите бургер", mainPage.getTextMakeBurger());
    }

    @Test
    @DisplayName("Переход на главную страницу из личного кабинета при нажатие на логотип")
    public void goToMainPageFromProfile() {
        accountPage = new AccountPage(driver);
        PageFactory.initElements(driver, accountPage);
        accountPage.waitForDisplayProfileText();
        accountPage.clickOnLogo();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForDisplayMakeBurgerText();
        Assert.assertEquals("Соберите бургер", mainPage.getTextMakeBurger());
    }

    @Test
    @DisplayName("Выход из личного кабинет")
    public void exitFromProfile() {
        accountPage = new AccountPage(driver);
        PageFactory.initElements(driver, accountPage);
        accountPage.waitForDisplayProfileText();
        accountPage.clickLogOutButton();
    }
}
