package pajeobject;

import constans.Url;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Url {

    public AccountPage(WebDriver driver) {
        super(driver);
        currentUrl = BASE_URL + ACCOUNT;
    }

    //текст Конструктор
    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement constructorButton;

    //текст Профиль
    @FindBy(xpath = ".//a[text() = 'Профиль']")
    private WebElement profile;

    //кнопка Выход
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement logOutButton;

    //шаги
    @Step("Создать заказ")
    public void clickConstructor() {
        constructorButton.click();
    }

    @Step("Клик на кнопку Выход")
    public void clickLogOutButton() {
        logOutButton.click();
    }

    @Step("Кликнуть на 'Профиль'")
    public void clickOnProfile(){
        profile.click();
    }
}
