package org.example.HWJFT6.TestHw1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPassPage extends StartKit {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    public LogPassPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LogPassPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public BasicPage clickLoginButton() {
        loginButton.click();
        return new BasicPage(driver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public LogPassPage(WebDriver driver) {
        super(driver);
    }
}
