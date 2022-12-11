package tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pajeobject.LoginPage;
import pajeobject.RegistrationPage;

public class RegistrationTest extends BaseTest{
    String password;
    String name = "Ivan";
    String email;
    RegistrationPage registrationPage;

    @Before
    public void start() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getCurrentUrl());

        email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
    }

    @Test
    @DisplayName("Создание валидного пользователя")
    public void createValidUserSuccessfullyCreated() {
        password = RandomStringUtils.randomAlphanumeric(10);

        registrationPage.setNameInput(name);
        registrationPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        registrationPage.clickSignUpButton();
        Assert.assertEquals(registrationPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Невреный пароль при создание нового пользователя")
    public void createUserWithIncorrectPasswordGetError() {

        password = "12";

        registrationPage.setNameInput(name);
        registrationPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        registrationPage.clickSignUpButton();

        Assert.assertEquals("Некорректный пароль", registrationPage.getIncorrectPasswordErrorText());
    }


}
