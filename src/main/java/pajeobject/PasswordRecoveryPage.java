package pajeobject;

import constans.Url;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PasswordRecoveryPage extends Url {

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
        currentUrl = BASE_URL + FORGOT_PASSWORD;
    }

    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement buttonForUpdateButton;

    @Step("Нажать на кнопку 'Восстановить'")
    public void clickButtonForUpdatePassword(){
        buttonForUpdateButton.click();
    }
}
