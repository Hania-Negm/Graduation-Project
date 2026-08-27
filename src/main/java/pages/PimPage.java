package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class PimPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PimPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locators

    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");

    private By employeeList = By.xpath("//a[text()='Employee List']");

    private By addEmployee = By.xpath("//a[text()='Add Employee']");


    @Step("Click PIM menu")
    public void clickPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    @Step("Click Employee List")
    public void clickEmployeeList() {

        wait.until(ExpectedConditions.elementToBeClickable(employeeList)).click();
    }

    @Step("Click Add Employee")
    public void clickAddEmployee() {

        wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();
    }

    @Step("Open Employee List from PIM")
    public void openEmployeeList() {

        clickPIM();
        clickEmployeeList();
    }

    @Step("Open Add Employee page from PIM")
    public void openAddEmployee() {

        clickPIM();
        clickAddEmployee();
    }
}