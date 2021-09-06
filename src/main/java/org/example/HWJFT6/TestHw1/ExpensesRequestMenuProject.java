package org.example.HWJFT6.TestHw1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesRequestMenuProject extends StartKit{
    public ExpensesRequestMenuProject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createExpenseXpathLocator)
    public WebElement createExpenseButton;

    public CreateExpensePageProject createExpense() {
        createExpenseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateExpensePageProject.saveAndCloseButtonXpathLocator)));
        return new CreateExpensePageProject(driver);
    }

    public static final String createExpenseXpathLocator = "//a[text()='Создать проект']";
}
