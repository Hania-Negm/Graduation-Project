package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators

    private By firstName = By.cssSelector("input[placeholder='First Name']");

    private By lastName = By.cssSelector("input[placeholder='Last Name']");

    private By saveButton = By.xpath("//button[@type='submit']");

    private By firstNameRequired = By.xpath("//input[@placeholder='First Name']/following::span[text()='Required'][1]");

    private By personalDetails = By.xpath("//h6[normalize-space()='Personal Details']");

    private By formLoader = By.cssSelector(".oxd-form-loader");


    // Constructor

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }


    @Step("Verify First Name field is displayed")
    public boolean isFirstNameDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).isDisplayed();
    }


    @Step("Verify Last Name field is displayed")
    public boolean isLastNameDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).isDisplayed();
    }


    @Step("Enter first name: {firstNameValue}")
    public void enterFirstName(String firstNameValue) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(firstNameValue);
    }


    @Step("Enter last name: {lastNameValue}")
    public void enterLastName(String lastNameValue) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lastNameValue);
    }


    @Step("Click Save button")
    public void clickSave() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }


    @Step("Verify First Name Required validation is displayed")
    public boolean isFirstNameRequiredDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameRequired)).isDisplayed();
    }


    @Step("Verify Personal Details page is displayed")
    public boolean isPersonalDetailsDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails)).isDisplayed();
    }
}