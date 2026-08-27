package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.TestDataProvider;

public class EmployeeTest extends BaseTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void searchForEmployeeTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        PimPage pimPage = new PimPage(getDriver());
        pimPage.openEmployeeList();

        EmployeeListPage employeeListPage = new EmployeeListPage(getDriver());

        employeeListPage.enterEmployeeName("Joseph  Evans");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isEmployeeDisplayed("Joseph  Evans"), "Employee 'Joseph  Evans' was not found in the results");
    }


    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void searchForNonExistingEmployeeTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        PimPage pimPage = new PimPage(getDriver());
        pimPage.openEmployeeList();

        EmployeeListPage employeeListPage = new EmployeeListPage(getDriver());

        employeeListPage.enterEmployeeName("XYZNonExisting123");
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isNoRecordsFoundDisplayed(), "No Records Found message is not displayed");
    }


    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void openAddEmployeePageTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");

        PimPage pimPage = new PimPage(getDriver());

        pimPage.openAddEmployee();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("/pim/addEmployee"), "URL does not contain /pim/addEmployee");

        AddEmployeePage addEmployeePage = new AddEmployeePage(getDriver());

        Assert.assertTrue(addEmployeePage.isFirstNameDisplayed(), "First Name field is not displayed");

        Assert.assertTrue(addEmployeePage.isLastNameDisplayed(), "Last Name field is not displayed");
    }


    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void addEmployeeWithEmptyFirstNameTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        PimPage pimPage = new PimPage(getDriver());
        pimPage.openAddEmployee();

        AddEmployeePage addEmployeePage = new AddEmployeePage(getDriver());

        addEmployeePage.enterLastName("Negm");
        addEmployeePage.clickSave();

        Assert.assertTrue(addEmployeePage.isFirstNameRequiredDisplayed(), "Required message is not displayed under First Name");
    }


    @Test(dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void addEmployeeSuccessfullyTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        PimPage pimPage = new PimPage(getDriver());

        pimPage.openAddEmployee();

        AddEmployeePage addEmployeePage = new AddEmployeePage(getDriver());

        addEmployeePage.enterFirstName("Hanya");
        addEmployeePage.enterLastName("Negm");

        addEmployeePage.clickSave();

        Assert.assertTrue(addEmployeePage.isPersonalDetailsDisplayed(), "Personal Details page is not displayed after saving employee");

        pimPage.openEmployeeList();

        EmployeeListPage employeeListPage = new EmployeeListPage(getDriver());

        String fullName = "Hanya Negm";

        employeeListPage.enterEmployeeName(fullName);
        employeeListPage.clickSearch();

        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(fullName), "New employee '" + fullName + "' was not found in the results");
    }
}