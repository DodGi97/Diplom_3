package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static constans.Path.PATH_TO_DRIVER_YANDEX;
import static constans.Path.PATH_TO_YANDEX_BROWSER;

public class BaseTest {
    WebDriver driver;
    //
    protected final String email = "fluer@yandex.ru";
    protected final String password = "TestPassword@1234!";

    @Before
    public void setup() {

        //тест на Google Chrome
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        //тесты на Yandex Browser раскоментировать перед выполнением.
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER_YANDEX);
        options.setBinary(PATH_TO_YANDEX_BROWSER);
        driver = new ChromeDriver(options);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
