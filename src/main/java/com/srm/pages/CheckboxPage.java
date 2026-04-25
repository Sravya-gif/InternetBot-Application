package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class CheckboxPage extends BasePage {

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    By checkboxLink = By.linkText("Checkboxes");
    By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    public void openCheckboxPage() {
        driver.findElement(checkboxLink).click();
        waitForElement(checkbox1);
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }

    public void toggleCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void toggleCheckbox2() {
        driver.findElement(checkbox2).click();
    }
}