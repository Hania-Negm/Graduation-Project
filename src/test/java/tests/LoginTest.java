package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.TestDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void validLoginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard header is not displayed");

        Assert.assertEquals(dashboardPage.getDashboardHeader(), "Dashboard", "Dashboard header text is incorrect");
    }


    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    public void invalidLoginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "Invalid credentials message is incorrect");
    }


    @Test
    public void emptyFieldsLoginTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getUsernameRequiredMessage(), "Required", "Username Required message is incorrect");

        Assert.assertEquals(loginPage.getPasswordRequiredMessage(), "Required", "Password Required message is incorrect");
    }
}