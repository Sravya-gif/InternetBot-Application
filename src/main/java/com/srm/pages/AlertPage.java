package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    By alertLink = By.linkText("JavaScript Alerts");
    By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    By resultText = By.id("result");

    public void openAlertPage() {
        driver.findElement(alertLink).click();
        waitForElement(jsAlertBtn);
    }

    public void clickJSAlert() {
        driver.findElement(jsAlertBtn).click();
        acceptAlert();
    }

    public void clickJSConfirmDismiss() {
        driver.findElement(jsConfirmBtn).click();
        dismissAlert();
    }

    public void clickJSPrompt(String text) {
        driver.findElement(jsPromptBtn).click();
        enterAlertText(text);
        acceptAlert();
    }

    public String getResultText() {
        waitForElement(resultText);
        return driver.findElement(resultText).getText();
    }
}