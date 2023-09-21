package org.selenium.pom.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    By StoreMenuLink = By.cssSelector("#menu-item-1227 > a");
    private final By Account = By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']");

    //  By StoreMenuLink=By.cssSelector("a.menu-link");
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage load() {
        loadpage("/");
        waitShort.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;

    }


    public StorePage ClickstoreMenuPage() {

        driver.findElement(StoreMenuLink).click();

        waitShort.until(ExpectedConditions.urlContains("/store"));
        return new StorePage(driver);
    }

    public account AccountPage() {
        webElementToBeClickable(Account);
        driver.findElement(Account).click();

        return new account(driver);
    }


}
