package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.CheckboxPage;
import com.srm.pages.DropdownPage;

import java.util.List;

public class CheckboxDropdownTest extends BaseTest {

    @Test
    public void testCheckboxes() {

        CheckboxPage cp = new CheckboxPage(driver);
        cp.openCheckboxPage();

        if (!cp.isCheckbox1Selected()) {
            cp.toggleCheckbox1();
        }
        Assert.assertTrue(cp.isCheckbox1Selected(), "Checkbox1 should be selected");
        cp.toggleCheckbox1();
        Assert.assertFalse(cp.isCheckbox1Selected(), "Checkbox1 should be unselected");

        boolean initialState = cp.isCheckbox2Selected();
        System.out.println("Checkbox2 initial state: " + initialState);

        cp.toggleCheckbox2();
        Assert.assertNotEquals(cp.isCheckbox2Selected(), initialState,
                "Checkbox2 state should change after toggle");
        System.out.println("Checkbox test PASSED");
    }

    @Test
    public void testDropdown() {

        DropdownPage dp = new DropdownPage(driver);
        dp.openDropdownPage();

        int count = dp.getOptionsCount();
        System.out.println("Dropdown options count: " + count);
        Assert.assertEquals(count, 3, "Dropdown should have 3 options");

        List<String> options = dp.getAllOptions();

        for (String option : options) {

            if (option.equals("Please select an option")) {
                continue;
            }

            dp.selectOption(option);
            String selected = dp.getSelectedOption();
            System.out.println("Selected: " + selected);
            Assert.assertEquals(selected, option,
                    "Dropdown selection mismatch");
        }
        System.out.println("Dropdown test PASSED");
    }
}