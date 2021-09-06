package org.example.HWJFT6;

import org.example.HWJFT6.TestHw1.ExpensesRequestMenuProject;
import org.example.HWJFT6.TestHw1.ExpensesSubMenuProject;
import org.example.HWJFT6.TestHw1.LogPassPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectHw1 extends StartTestHw1{

    @Test
    void loginCrmWithPageObjectTestHw1() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/");
        new LogPassPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .roadMapMenu.openRoadMapMenuItems("Проекты");

        new ExpensesSubMenuProject(driver).goToAllProjectsPage();

        new ExpensesRequestMenuProject(driver)
                .createExpense()
                .fillNameProject("Project Company")
                .selectAllOrg("«Все организации»")
                .classBusinessUnitSelect("Средний")
                .financeUnitSelect("Внутреннее")
                .subdivisionUnitSelect("Research & Development")
                .curatorUnitSelect("Applanatest Applanatest Applanatest")
                .rpUnitSelect("Applanatest Applanatest Applanatest")
                .manageUnitSelect("Applanatest Applanatest Applanatest")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'Загрузка')]")));

//        assertThat(new CreateExpensePageProject(driver).requestSavedSuccessfullyElement, isDisplayed());


    }
}
