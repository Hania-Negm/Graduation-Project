# 🚀 OrangeHRM Automation Testing Project

A complete **Web UI Automation Testing Framework** for the OrangeHRM Open Source Demo using **Selenium WebDriver, Java, TestNG, Maven, POM, Data-Driven Testing, Parallel Execution, and Allure Reporting**.

## 🛠️ Tech Stack

* ☕ Java 25
* 🧪 Selenium WebDriver 4.45.0
* 🔬 TestNG 7.12.0
* 📦 Maven
* 🏗️ Page Object Model (POM)
* 📄 JSON + Jackson for test data
* ⚡ ThreadLocal WebDriver for parallel execution
* 📊 Allure Report
* 🔧 IntelliJ IDEA

## 🎯 Automated Test Scenarios

The framework covers **11 test cases**:

1. Login with valid credentials
2. Login with invalid credentials
3. Login with empty fields
4. Search for an existing employee
5. Search for a non-existing employee
6. Open Add Employee page
7. Add employee with missing required field
8. End-to-End: Add a new employee successfully
9. Verify Admin → Add User page
10. Verify OrangeHRM footer and branding link
11. Verify sidebar menu items

## 🏛️ Framework Structure

```text
src
├── main
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── DashboardPage.java
│       │   ├── PimPage.java
│       │   ├── EmployeeListPage.java
│       │   ├── AddEmployeePage.java
│       │   ├── AdminPage.java
│       │   ├── FooterPage.java
│       │   └── SidebarPage.java
│       └── utilities
│           └── ConfigReader.java
│
├── test
│   ├── java
│   │   ├── tests
│   │   │   ├── LoginTest.java
│   │   │   ├── EmployeeTest.java
│   │   │   ├── AdminTest.java
│   │   │   ├── FooterTest.java
│   │   │   └── SidebarTest.java
│   │   └── utilities
│   │       └── TestDataProvider.java
│   │
│   └── resources
│       ├── config.properties
│       └── testData.json
│
├── testng.xml
└── pom.xml
```

## ✨ Key Framework Features

### Page Object Model

All page locators and UI actions are separated from test classes to keep the framework clean, reusable, and maintainable.

### 🔄 Data-Driven Testing

Login and test data are stored externally in JSON and supplied to TestNG tests through a `DataProvider`.

### ⚡ Parallel Execution

Tests are configured to run in parallel using:

```xml
parallel="tests"
```

A `ThreadLocal<WebDriver>` is used so every parallel test receives its own independent browser instance.

### ⏱️ Explicit Waits

The framework uses Selenium `WebDriverWait` and `ExpectedConditions` instead of `Thread.sleep()`.

### 📊 Allure Reporting

Allure is integrated with TestNG to provide detailed execution reports and test steps.

## ▶️ Run the Tests

Run all tests using Maven:

```bash
mvn test
```

Generate the Allure HTML report:

```bash
allure generate allure-results --clean -o allure-report
```

Open the report:

```bash
allure open allure-report
```

## 📁 Git & Reporting

The generated `allure-report` is included in the repository for viewing the static report.

The temporary `allure-results` directory is excluded from Git.

## 🌐 Application Under Test

**OrangeHRM Open Source Demo**

https://opensource-demo.orangehrmlive.com/

## 👩‍💻 Author

**Hania Negm**

> Built as a graduation automation testing project using Selenium WebDriver and TestNG.
