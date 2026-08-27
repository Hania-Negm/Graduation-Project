package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.LoginPage;
import utilities.JsonDataReader;

import java.time.Duration;

public class FooterTest extends BaseTest {

    @Test
    public void verifyOrangeHRMFooterLinkTest() {

        // Login
        LoginPage loginPage = new LoginPage(getDriver());

        String username = JsonDataReader.getData("validLogin", "username");

        String password = JsonDataReader.getData("validLogin", "password");

        loginPage.login(username, password);

        // Footer
        FooterPage footerPage = new FooterPage(getDriver());

        footerPage.scrollToFooter();

        Assert.assertTrue(footerPage.isFooterDisplayed(), "OrangeHRM footer link is not displayed");

        Assert.assertTrue(footerPage.getFooterText().contains("OrangeHRM, Inc"), "Footer text does not contain 'OrangeHRM, Inc'");

        // Save current window
        String currentWindow = getDriver().getWindowHandle();

        // Click footer link
        footerPage.clickOrangeHRMLink();

        // Wait until new window/tab opens
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to new tab
        for (String window : getDriver().getWindowHandles()) {

            if (!window.equals(currentWindow)) {
                getDriver().switchTo().window(window);
                break;
            }
        }

        // Verify URL
        wait.until(ExpectedConditions.urlContains("orangehrm.com"));

        Assert.assertTrue(getDriver().getCurrentUrl().contains("orangehrm.com"), "OrangeHRM link did not open orangehrm.com");
    }
}