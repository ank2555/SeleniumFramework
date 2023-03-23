package org.selenium.pom.Pages;

import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.checkerframework.framework.qual.EnsuresQualifierIf;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.Objects.Billinginformation;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class checkoutPage extends BasePage


{
    public checkoutPage(WebDriver driver)
    {
        super(driver);
    }

    private  final  By cartPage=By.cssSelector(".has-text-align-center");
    private final   By firstName= By.cssSelector("#billing_first_name");
    private final   By lastName= By.cssSelector("#billing_last_name");
    private final   By billingCompany= By.cssSelector("#billing_company");
    private final   By billiingAddress1= By.cssSelector("#billing_address_1");
    private final   By billiingCity= By.cssSelector("#billing_city");
    private final   By billingPostcode= By.cssSelector("#billing_postcode");
    private final   By billingEmail= By.cssSelector("#billing_email");
    private final   By textValidation= By.cssSelector(".woocommerce-notice");
    private  final  By placeOrder=By.cssSelector("[name='woocommerce_checkout_place_order'][id='place_order']");
    private final   By loginbtn= By.cssSelector(".showlogin");
    private final   By directBankTrasnferBttn=By.id("payment_method_bacs");
    //private  final By CountryDropDown =By.cssSelector("label[for='billing_country']");
   private  final By CountryDropDown = By.id("billing_country");
    private final By StateDropDown=By.id("[id='billing_state']");
    private  final  By  overlay=By.cssSelector(".blockUI.blockOverlay");
  //  private final By overlay= By.cssSelector("[class='blockUI']");





    public checkoutPage setFirstName(String fname)
    {

        webElementToBeVisible(firstName);
        WebElement e= waitShort.until(ExpectedConditions.visibilityOfElementLocated(firstName));
 e.clear();
 e.click();
 e.sendKeys(fname);
     //   driver.findElement(firstName).click();
       // driver.findElement(firstName).sendKeys(fname);
     return this;
    }


    public checkoutPage setLastName(String lname)
    {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).click();
        driver.findElement(lastName).sendKeys(lname);
        return this;
    }


    public checkoutPage setCompany(String company)
    {
        driver.findElement(billingCompany).clear();
        driver.findElement(billingCompany).sendKeys(company);
        return this;
    }

    public checkoutPage setBilliingAddress1(String address1)
    {
        driver.findElement(billiingAddress1).clear();
        driver.findElement(billiingAddress1).sendKeys(address1);
        return this;
    }

public checkoutPage setCountry(String CountryName)
{



/*    Select select=new Select(driver.findElement(CountryDropDown));
List<WebElement> options=select.getOptions();

for (WebElement a:options)
{
    System.out.println(a.getText());
    //select.selectByIndex(2);

}*/     //------This is Code is valid for Chrome Driver and Browser

///---------Below is Alternate code for FireFox Driver as there i Bug raised for fire Fox Driver---------//
    By CountrydropDown =By.id("select2-billing_country-container");
    webElementToBeClickable(CountrydropDown).click();
    WebElement elem =waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+CountryName+"']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elem);
    elem.click();
    return this;

/*
    select.selectByVisibleText(CountryName);
    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='billing_country']//option[contains(text(),'Select a country / region…')]"))).click();
    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(CountryDropDown)).click();
    new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOfElementLocated(By.id("billing_country")));



    Select s=new select()
    elem.scrollIntoView();
    JavascriptExecutor js = (JavascriptExecutor) driver;


    select.selectByValue("IN");
select.selectByVisibleText(CountryName);
  new WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//select[@id='providerTypeDropDown']//options[contains(.,'Professional')]")))
    dropDownMenu.select_by_visible_text('Professional')
    select.selectByVisibleText(CountryName);*/

}

public checkoutPage setState(String StateName)
{
   /* Select select=new Select(driver.findElement(StateDropDown));

    select.selectByVisibleText(StateName);
    return this;*/


///---------Below is Alternate code for FireFox Driver as there i Bug raised for fire Fox Driver---------//
    By CountrydropDown =By.id("select2-billing_state-container");
    webElementToBeClickable(CountrydropDown).click();
    WebElement elem =waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+StateName+"']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elem);
    elem.click();
    return this;


}



    public checkoutPage setBilliingCity(String city)
    {

        driver.findElement(billiingCity).clear();
        driver.findElement(billiingCity).sendKeys(city);
        return this;
    }

    public checkoutPage setBillingPostcode(String postcode)
    {

        driver.findElement(billingPostcode).clear();
        driver.findElement(billingPostcode).sendKeys(postcode);
        return this;
    }

    public checkoutPage setbillingEmail(String email)
    {
        driver.findElement(billingEmail).clear();
        driver.findElement(billingEmail).sendKeys(email);
        return this;
    }


      public checkoutPage setBillinginformation( Billinginformation billinginformation)
      {

           setFirstName(billinginformation.getFirstname()).
                  setLastName(billinginformation.getLastname()).
                  setCompany(billinginformation.getCompany()).
                  setCountry(billinginformation.getCountryName()).
                  setBilliingAddress1(billinginformation.getAddressLineone()).
                  setBilliingCity(billinginformation.getCity()).
                  setState(billinginformation.getStateName()).
                  setBillingPostcode(billinginformation.getPostcode()).
          setbillingEmail(billinginformation.getEmail());






          return this;
      }

    public checkoutPage  setPlaceOrder()
    {

        //waitShort.until(ExpectedConditions.visibilityOfElementLocated(billingPostcode));

       waitForOverlaytoDisappear(overlay);

      //  waitShort.until(ExpectedConditions.invisibilityOfAllElements((WebElement) overlay));
        driver.findElement(By.cssSelector(".wp-block-group.alignfull")).click();
        //waitLong.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
        driver.findElement(placeOrder).click();
        return this;
    }


    public checkoutPage DirectBankTransfer(By directBankTrasnferBttn)
    {
       WebElement element =waitShort.until(ExpectedConditions.visibilityOfElementLocated(directBankTrasnferBttn));
       if (!element.isSelected())
       {
           element.click();
       }

        return  this;

    }

    public  boolean PagedLoaded()
    {


        return  waitShort.until(ExpectedConditions.textToBe(cartPage,"Cart"));

    }



    public String  setTextValidation()
    {
       return webElementToBeVisible(textValidation).getText();
      //  return driver.findElement(textValidation).getText();
    }

    public  loginPage login()
    {


      //  System.out.println("ovelays objects are null ");
        webElementToBeClickable(loginbtn);
        driver.findElement(loginbtn).click();
        return new loginPage(driver);
    }






}
