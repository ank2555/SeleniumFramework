package org.selenium.pom.Pages;

import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    private final By username = By.cssSelector("#username");
    private final By password = By.cssSelector("#password");
    private final By clicklogin = By.cssSelector("button[value='Login']");


    private loginPage setUsername(String usrname) {
        webElementToBeVisible(username).click();
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(usrname);
        return this;
    }


    private loginPage setPassword(String pswd) {
        driver.findElement(password).sendKeys(pswd);
        return this;
    }


    public void clikLogin(String username, String Password) {

        setUsername(username);
        setPassword(Password);
        driver.findElement(clicklogin).click();
    }
}
