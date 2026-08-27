package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locator

    private By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");


    @Step("Verify Dashboard header is displayed")
    public boolean isDashboardDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }


    @Step("Get Dashboard header text")
    public String getDashboardHeader() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).getText();
    }
}