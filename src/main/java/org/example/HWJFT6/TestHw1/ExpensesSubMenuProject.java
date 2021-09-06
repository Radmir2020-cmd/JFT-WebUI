package org.example.HWJFT6.TestHw1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesSubMenuProject extends StartKit{
    public ExpensesSubMenuProject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@data-route='crm_project_index']/a")
    public WebElement expensesRequestMenuItem;

    public void goToAllProjectsPage() {
        expensesRequestMenuItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(ExpensesRequestMenuProject.createExpenseXpathLocator)));

    }
}
