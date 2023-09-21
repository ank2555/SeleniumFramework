package org.selenium.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.Objects.AccountCreationUsers;

public class account extends BasePage {

    public account(WebDriver driver) {
        super(driver);
    }


    private final By RegisterText = By.xpath("//h2[normalize-space()='Register']");
    private final By Username = By.cssSelector("#reg_username");
    private final By Password = By.cssSelector("#reg_password");
    private final By Email_id = By.cssSelector("#reg_email");
    private final By Register = By.cssSelector("button[value='Register']");


    public String RegisterText() {
        return driver.findElement(RegisterText).getText();
    }

    private void SetUsername(String username) {
        driver.findElement(Username).clear();
        driver.findElement(Username).sendKeys(username);


    }


    private void SetPassword(String password) {
        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys(password);
    }

    private void Email(String email) {
        driver.findElement(Email_id).clear();
        driver.findElement(Email_id).sendKeys(email);
    }


    private void RegisterButton() {
        webElementToBeVisible(Register);
        driver.findElement(Register).click();
    }


    public account ClickRegister(AccountCreationUsers accountCreationUsers) {

        waitLong.until(ExpectedConditions.visibilityOfElementLocated(Username));
        SetUsername(accountCreationUsers.getUsername());
        Email(accountCreationUsers.getEmail());
        SetPassword(accountCreationUsers.getPassword());
        RegisterButton();


        return this;
    }


}
