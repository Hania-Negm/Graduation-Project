package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class FooterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("explicit.wait"))));
    }

    // Locators

    private By orangeHRMLink = By.xpath("//a[contains(text(),'OrangeHRM, Inc')]");


    // Actions

    @Step("Scroll to the footer")
    public void scrollToFooter() {

        WebElement footerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(orangeHRMLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", footerLink);
    }


    @Step("Verify OrangeHRM footer link is displayed")
    public boolean isFooterDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(orangeHRMLink)).isDisplayed();
    }


    @Step("Get OrangeHRM footer text")
    public String getFooterText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(orangeHRMLink)).getText();
    }


    @Step("Click OrangeHRM footer link")
    public void clickOrangeHRMLink() {

        wait.until(ExpectedConditions.elementToBeClickable(orangeHRMLink)).click();
    }
}