# InternetBot Automation Framework

## Project Description

This project is a Selenium Java Automation Framework developed using Page Object Model (POM) to automate testing of The Internet Herokuapp application. It covers authentication, alerts, file upload, dynamic elements.

## Features

* Authentication Testing (Valid, Invalid, Empty Login)
* JavaScript Alerts Handling (Alert, Confirm, Prompt)
* Checkbox and Dropdown Validation
* File Upload Automation (SendKeys & AutoIT)
* Dynamic Loading and Content Verification
* Screenshot Capture on Failure
* Extent HTML Reports
* Configurable Browser Execution

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

## Modules Covered

* Authentication – Login and Logout validation  
* Alerts – JS Alert, Confirm, Prompt handling  
* Elements – Checkboxes, Dropdown  
* File Upload – Upload validation and negative scenarios  
* Dynamic Loading – Wait handling and content verification  

## Reports

Execution reports are generated in the `/reports` folder using ExtentReports with test status and screenshots.

## Screenshots

Failure screenshots are automatically captured and stored in the `/screenshots` folder.
2. Update `config.properties` if needed  
3. Run using command:
