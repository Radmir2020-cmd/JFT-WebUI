package org.example.HWJFT6.TestHw1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateExpensePageProject extends StartKit{
    public CreateExpensePageProject(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement expenseRequestName;

    public CreateExpensePageProject fillNameProject(String name) {
        expenseRequestName.sendKeys(name);
        return this;
    }

    @FindBy(name = "//span[text()='Укажите организацию']")
    public WebElement selectBusinessUnit;

    @FindBy(name = "//div[text()='«Все организации»']")
    public List<WebElement> selectBusinessUnitOrg;

    public CreateExpensePageProject selectAllOrg(String allOrg) {
        selectBusinessUnit.click();
        selectBusinessUnitOrg.stream()
                .filter(element -> element.getText().equals(allOrg))
                .findFirst().get().click();
        return this;
    }

//    public CreateExpensePageProject selectBusinessUnit(String businessUnit) {
//        new Select(selectBusinessUnit).selectByVisibleText(businessUnit);
//        return this;
//    }

    @FindBy(name = "//select[@name='crm_project[priority]']")
    public WebElement classBusinessUnitSelect;

    public CreateExpensePageProject classBusinessUnitSelect(String priority) {
        new Select(classBusinessUnitSelect).selectByVisibleText(priority);
        return this;
    }

    @FindBy(name = "//select[@name='crm_project[financeSource]']")
    public WebElement financeUnitSelect;

    public CreateExpensePageProject financeUnitSelect(String financeSource) {
        new Select(financeUnitSelect).selectByVisibleText(financeSource);
        return this;
    }

    @FindBy(name = "//select[@name='crm_project[businessUnit]']")
    public WebElement subdivisionUnitSelect;

    public CreateExpensePageProject subdivisionUnitSelect(String businessUnit) {
        new Select(subdivisionUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "//select[@name='crm_project[curator]']")
    public WebElement curatorUnitSelect;

    public CreateExpensePageProject curatorUnitSelect(String curator) {
        new Select(curatorUnitSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "//select[@name='crm_project[rp]']")
    public WebElement rpUnitSelect;

    public CreateExpensePageProject rpUnitSelect(String rp) {
        new Select(rpUnitSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "//select[@name='crm_project[manager]']")
    public WebElement manageUnitSelect;

    public CreateExpensePageProject manageUnitSelect(String manager) {
        new Select(manageUnitSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

//    @FindBy(xpath = "//*[@text()='Заявка на расход сохранена']")
//    public WebElement requestSavedSuccessfullyElement;

}
