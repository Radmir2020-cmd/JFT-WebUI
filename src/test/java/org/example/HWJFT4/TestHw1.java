package org.example.HWJFT4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestHw1 {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void regDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }

    @Test
    void checkProjectCompany() {
        Actions actions = new Actions(driver);

        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Project Company");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select businessUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[priority]']")));
        businessUnitSelect.selectByVisibleText("Средний");

        Select financeUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[financeSource]']")));
        financeUnitSelect.selectByVisibleText("Внутреннее");

        Select subdivisionUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[businessUnit]']")));
        subdivisionUnitSelect.selectByVisibleText("Research & Development");

        Select curatorUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[curator]']")));
        curatorUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select rpUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[rp]']")));
        rpUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select manageUnitSelect = new Select(driver.findElement(By.xpath(
                "//select[@name='crm_project[manager]']")));
        manageUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        List<WebElement> headersList = driver.findElements(
                By.xpath("//select[@name='crm_project[priority]']"));
        Assertions.assertEquals("средний", headersList.get(0).getText());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

}
