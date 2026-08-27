package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        WebDriver webDriver = new ChromeDriver(options);

        driver.set(webDriver);

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        getDriver().get(ConfigReader.getProperty("base.url"));
        System.out.println("Thread: " + Thread.currentThread().getId() + " | URL: " + getDriver().getCurrentUrl());
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}