package org.selenium.pom.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class cartPage extends BasePage {


/*
   private final By CartDetail=By.cssSelector("td[class='product-name'] a");
   private final By Checkout=By.cssSelector(".checkout-button.button.alt.wc-forward");*/

    public cartPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".has-text-align-center")
    private WebElement cartPage;
    @FindBy(css = "td[class='product-name'] a")
    private WebElement CartDetail;
    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    @CacheLookup
    private WebElement Checkout;






/*
    public  boolean PagedLoaded()
    {


       return  waitShort.until(ExpectedConditions.textToBe(cartPage,"Cart"));

    }
*/


    public String checkCartProduct() {

        return waitShort.until(ExpectedConditions.elementToBeClickable(CartDetail)).getText();
        // return driver.findElement(CartDetail).getText();
    }


    public checkoutPage checkoutMethod() {
        Checkout.click();
        //driver.findElement(Checkout).click();
        return new checkoutPage(driver);
    }

}
