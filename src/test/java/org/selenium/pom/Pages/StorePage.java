package org.selenium.pom.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {


    private final By SearchField = By.cssSelector("[class='search-field']");
    private final By SearchBtn = By.cssSelector("button[value='Search']");
    //  private final    By SearchedValue= By.cssSelector("[class$='title page-title']");
    private final By SearchedValue = By.xpath("//h1[contains(text(),'Search results: “Bracelet”')]");
    private final By ViewCart = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }


    public Boolean pageLoaded() {
        return waitShort.until(ExpectedConditions.urlContains("/store"));

    }

    private StorePage EnterTextEarchField(String txt) {

        webElementToBeVisible(SearchField);
        driver.findElement(SearchField).sendKeys(txt);
        return this;
    }

    private StorePage clickSearchBTn() {
        webElementToBeClickable(SearchBtn);
        driver.findElement(SearchBtn).click();
        return this;
    }


    public StorePage search(String txt) {
        // driver.findElement(SearchField).sendKeys(txt);


        EnterTextEarchField(txt).clickSearchBTn();
        // driver.findElement(SearchBtn).click();
        return this;
    }


    public String gettitle() {
        //Assert.assertEquals(driver.findElement(SearchedValue).getText(),);
        //    waitShort.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SearchedValue));
        webElementToBeVisible(SearchedValue);
        return driver.findElement(SearchedValue).getText();
    }

    private By ProductNameElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

    }


    public StorePage addToCart(String productName) {

        By AddtoCartBtn = ProductNameElement(productName);
        driver.findElement(AddtoCartBtn).click();
        return this;
    }

    public cartPage viewCart() {
        webElementToBeVisible(ViewCart);
        driver.findElement(ViewCart).click();
        return new cartPage(driver);
    }


}
