package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.srm.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    By dropdownLink = By.linkText("Dropdown");
    By dropdown = By.id("dropdown");

    public void openDropdownPage() {
        driver.findElement(dropdownLink).click();
        waitForElement(dropdown);
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(option);
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    public int getOptionsCount() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getOptions().size();
    }

    public List<String> getAllOptions() {

        Select select = new Select(driver.findElement(dropdown));
        List<String> optionTexts = new ArrayList<>();
        List<org.openqa.selenium.WebElement> options = select.getOptions();

        for (int i = 0; i < options.size(); i++) {
            optionTexts.add(options.get(i).getText());
        }
        return optionTexts;
    }
}