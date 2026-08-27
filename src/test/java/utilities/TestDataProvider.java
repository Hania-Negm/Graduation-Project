package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {

        return new Object[][]{{JsonDataReader.getData("validLogin", "username"), JsonDataReader.getData("validLogin", "password")}};
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][]{{JsonDataReader.getData("invalidLogin", "username"), JsonDataReader.getData("invalidLogin", "password")}};
    }

    @DataProvider(name = "employeeNamesData")
    public static Object[][] employeeNamesData() {

        return new Object[][]{{JsonDataReader.getData("searchEmployee", "name"), JsonDataReader.getData("nonExistingEmployee", "name")}};
    }

    @DataProvider(name = "newEmployeeData")
    public static Object[][] newEmployeeData() {

        return new Object[][]{{JsonDataReader.getData("newEmployee", "firstName"), JsonDataReader.getData("newEmployee", "lastName")}};
    }
}