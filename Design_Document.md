# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Features

* Config-driven execution using `config.properties`
* Data-driven testing using TestNG DataProvider
* Reusable Page methods following POM design
* FluentWait/WebDriverWait for dynamic elements (No Thread.sleep)
* Screenshot capture on failure using TestNG Listener
* ExtentReports for HTML reporting
* WebDriverManager for automatic driver setup
* File upload automation using Selenium (sendKeys) and AutoIT (SciTE)

---

## Test Coverage

* Authentication
* JavaScript Alerts
* UI Elements(Checkbox and Dropdown selection verification)
* File Upload
* Dynamic Elements

---

## Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports
* AutoIT (SciTE) for file upload handling

---

## File Upload Approach

* Primary method: Selenium `sendKeys()` for direct file upload
* Secondary method: AutoIT script created using SciTE and compiled to `.exe`
* AutoIT handles OS-level file upload popup which Selenium cannot control directly

---

## Framework Components

* Base Classes → Driver setup and common methods  
* Page Classes → UI actions and locators  
* Test Classes → Test logic and assertions  
* Utilities → ConfigReader, WaitUtil, ScreenshotUtil  
* Listener → Screenshot capture and reporting  
* Reports → Extent HTML reports  
* Screenshots → Stored on test failure  

---

## Project Structure
```
InternetBot
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.driver
│   │   └── DriverFactory.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── LoginPage.java
│   │   ├── AlertPage.java
│   │   ├── CheckboxPage.java
│   │   ├── DropdownPage.java
│   │   ├── DynamicPage.java
│   │   └── UploadPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExtentManager.java
│   │   ├── ScreenshotUtil.java
│   │   └── WaitUtil.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── AlertTest.java
│       ├── CheckboxDropdownTest.java
│       ├── UploadTest.java
│       └── DynamicTest.java
│
├── screenshots
│   
│
├── reports
│   
│
├── testng.xml
│
├── pom.xml

```
