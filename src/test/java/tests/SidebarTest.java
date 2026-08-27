package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import utilities.JsonDataReader;

public class SidebarTest extends BaseTest {

    @Test
    public void verifySidebarMenuTest() {

        // Login
        LoginPage loginPage = new LoginPage(getDriver());

        String username = JsonDataReader.getData("validLogin", "username");

        String password = JsonDataReader.getData("validLogin", "password");

        loginPage.login(username, password);

        // Sidebar
        SidebarPage sidebarPage = new SidebarPage(getDriver());

        // Verify sidebar menu items

        Assert.assertTrue(sidebarPage.isAdminDisplayed(), "Admin menu is not displayed");

        Assert.assertTrue(sidebarPage.isPimDisplayed(), "PIM menu is not displayed");

        Assert.assertTrue(sidebarPage.isLeaveDisplayed(), "Leave menu is not displayed");

        Assert.assertTrue(sidebarPage.isTimeDisplayed(), "Time menu is not displayed");

        Assert.assertTrue(sidebarPage.isRecruitmentDisplayed(), "Recruitment menu is not displayed");

        Assert.assertTrue(sidebarPage.isMyInfoDisplayed(), "My Info menu is not displayed");

        Assert.assertTrue(sidebarPage.isPerformanceDisplayed(), "Performance menu is not displayed");

        Assert.assertTrue(sidebarPage.isDashboardDisplayed(), "Dashboard menu is not displayed");

        Assert.assertTrue(sidebarPage.isDirectoryDisplayed(), "Directory menu is not displayed");
    }
}