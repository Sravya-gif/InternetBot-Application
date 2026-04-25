package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    By uploadLink = By.linkText("File Upload");
    By fileInput = By.id("file-upload");
    By uploadBtn = By.id("file-submit");
    By uploadedText = By.id("uploaded-files");
    By pageTitle = By.tagName("h3");

    public void openUploadPage() {
        driver.findElement(uploadLink).click();
        waitForElement(fileInput); 
    }

    public void uploadFile(String path) {
        waitForElement(fileInput);
        driver.findElement(fileInput).sendKeys(path);
        driver.findElement(uploadBtn).click();
    }
    
    public void clickUploadButton() {
        driver.findElement(uploadBtn).click();
    }

    public void uploadUsingAutoIT(String exePath) {

        driver.findElement(fileInput).click();

        try {
            Runtime.getRuntime().exec(exePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.findElement(uploadBtn).click();
    }

    public String getUploadedFileName() {
        waitForElement(uploadedText);
        return driver.findElement(uploadedText).getText();
    }

    public String getPageTitleText() {
        waitForElement(pageTitle);
        return driver.findElement(pageTitle).getText();
    }
}