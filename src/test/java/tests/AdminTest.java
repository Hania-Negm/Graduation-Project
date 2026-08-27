package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class AdminTest extends BaseTest {

    @Test
    public void verifyAddUserPageTest() {

        // Login
        LoginPage loginPage = new LoginPage(getDriver());

        String username = JsonDataReader.getData("validLogin", "username");

        String password = JsonDataReader.getData("validLogin", "password");

        loginPage.login(username, password);


        // Navigate to Admin
        AdminPage adminPage = new AdminPage(getDriver());

        adminPage.openAdmin();


        // Click Add
        adminPage.clickAdd();


        // Assertions
        Assert.assertTrue(adminPage.isUserRoleDisplayed(), "User Role field is not displayed");

        Assert.assertTrue(adminPage.isEmployeeNameDisplayed(), "Employee Name field is not displayed");

        Assert.assertTrue(adminPage.isUsernameDisplayed(), "Username field is not displayed");

        Assert.assertTrue(adminPage.isPasswordDisplayed(), "Password field is not displayed");
    }
}