package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

import io.qameta.allure.Step;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locators

    private By usernameField = By.name("username");

    private By passwordField = By.name("password");

    private By loginButton = By.cssSelector("button[type='submit']");

    private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    private By usernameRequired = By.xpath("(//span[contains(@class,'oxd-input-field-error-message')])[1]");

    private By passwordRequired = By.xpath("(//span[contains(@class,'oxd-input-field-error-message')])[2]");


    @Step("Wait for Login page to be displayed")
    public void waitForLoginPage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }


    @Step("Enter username: {username}")
    public void enterUsername(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }


    @Step("Enter password")
    public void enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }


    @Step("Click Login button")
    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


    @Step("Login with username: {username}")
    public void login(String username, String password) {

        waitForLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }


    @Step("Get login error message")
    public String getErrorMessage() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }


    @Step("Get username required validation message")
    public String getUsernameRequiredMessage() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameRequired)).getText();
    }


    @Step("Get password required validation message")
    public String getPasswordRequiredMessage() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequired)).getText();
    }
}