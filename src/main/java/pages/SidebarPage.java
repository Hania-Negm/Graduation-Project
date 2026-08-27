package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class SidebarPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Sidebar menu items

    private By adminMenu = By.xpath("//span[normalize-space()='Admin']");

    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");

    private By leaveMenu = By.xpath("//span[normalize-space()='Leave']");

    private By timeMenu = By.xpath("//span[normalize-space()='Time']");

    private By recruitmentMenu = By.xpath("//span[normalize-space()='Recruitment']");

    private By myInfoMenu = By.xpath("//span[normalize-space()='My Info']");

    private By performanceMenu = By.xpath("//span[normalize-space()='Performance']");

    private By dashboardMenu = By.xpath("//span[normalize-space()='Dashboard']");

    private By directoryMenu = By.xpath("//span[normalize-space()='Directory']");


    public boolean isAdminDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenu)).isDisplayed();
    }

    public boolean isPimDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu)).isDisplayed();
    }

    public boolean isLeaveDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveMenu)).isDisplayed();
    }

    public boolean isTimeDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeMenu)).isDisplayed();
    }

    public boolean isRecruitmentDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(recruitmentMenu)).isDisplayed();
    }

    public boolean isMyInfoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myInfoMenu)).isDisplayed();
    }

    public boolean isPerformanceDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(performanceMenu)).isDisplayed();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardMenu)).isDisplayed();
    }

    public boolean isDirectoryDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(directoryMenu)).isDisplayed();
    }
}