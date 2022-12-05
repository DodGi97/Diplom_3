package constans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Url {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    public static final String FORGOT_PASSWORD = "forgot-password";
    public static final String REG = "register";
    public static final String EMAIL = "test_g@yandex.ru";
    public static final String PASSWORD = "TestPassword1234!";

    public WebDriver driver;

    protected String currentUrl;

    public Url(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

}
