package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class EmployeeListPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locators

    private By employeeNameField = By.xpath("//label[text()='Employee Name']/following::input[1]");

    private By searchButton = By.xpath("//button[@type='submit']");

    private By resultsTable = By.xpath("//div[contains(@class,'oxd-table-body')]");

    private By noRecordsFound = By.xpath("//span[text()='No Records Found']");


    @Step("Enter employee name")
    public void enterEmployeeName(String employeeName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField)).sendKeys(employeeName);
    }

    @Step("Click Search button")
    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isResultsTableDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable)).isDisplayed();
    }

    public boolean isNoRecordsFoundDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsFound)).isDisplayed();
    }

    public boolean isEmployeeDisplayed(String employeeName) {

        String normalizedName = employeeName.replaceAll("\\s+", " ").trim();

        By employee = By.xpath("//div[contains(@class,'oxd-table-body')]" + "//div[contains(@class,'oxd-table-row')]" + "[contains(normalize-space(.), '" + normalizedName + "')]");

        return wait.until(ExpectedConditions.visibilityOfElementLocated(employee)).isDisplayed();
    }
}