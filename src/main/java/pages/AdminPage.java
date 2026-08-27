package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locators

    private By adminMenu = By.xpath("//span[normalize-space()='Admin']");

    private By addButton = By.xpath("//button[contains(.,'Add')]");

    private By userRoleLabel = By.xpath("//label[text()='User Role']");

    private By employeeNameLabel = By.xpath("//label[text()='Employee Name']");

    private By usernameLabel = By.xpath("//label[text()='Username']");

    private By passwordLabel = By.xpath("//label[text()='Password']");


    @Step("Open Admin menu")
    public void openAdmin() {

        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }


    @Step("Click Add button")
    public void clickAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }


    @Step("Verify User Role field is displayed")
    public boolean isUserRoleDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleLabel)).isDisplayed();
    }


    @Step("Verify Employee Name field is displayed")
    public boolean isEmployeeNameDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameLabel)).isDisplayed();
    }


    @Step("Verify Username field is displayed")
    public boolean isUsernameDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLabel)).isDisplayed();
    }


    @Step("Verify Password field is displayed")
    public boolean isPasswordDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLabel)).isDisplayed();
    }
}