package org.example.HWJFT4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHw1Ololosh {
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
    void checkRegOlolosh() {
        Actions actions = new Actions(driver);

        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[@class='pull-left btn-group icons-holder']/a"))) ;
        driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Ололошев");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//input[@name='crm_contact[firstName]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys("Ололош");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//input[@name='crm_contact[jobTitle]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']"))
                .sendKeys("Окушер-Трубоукладчик");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
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
