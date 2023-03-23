package org.selenium.pom.tests;

//import *;
import org.openqa.selenium.By;
import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.Objects.AccountCreationUsers;
import org.selenium.pom.Objects.Billinginformation;
import org.selenium.pom.Pages.*;
import org.selenium.pom.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class myFirstTest  extends BaseTest {

  //  public static WebDriver driver=null;


    private static final Logger LOG = LoggerFactory
            .getLogger(myFirstTest.class);






//@Test
    public void AccountCreation() throws  IOException {

    AccountCreationUsers accountCreationUsers=JacksonUtils.Fileloader("AccountUserdetails.json", AccountCreationUsers.class);
 account account=new HomePage(  getDriver()).load().AccountPage();
        //account account=new HomePage(getDriver()).AccountPage().ClickRegister(accountCreationUsers);
         Assert.assertEquals(account.RegisterText(),"Register");
         account.ClickRegister(accountCreationUsers);





/*

        driver.findElement(By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']")).click();
    Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Register']")).getText(),
                "Register"
        );
    Thread.sleep(1000);
        driver.findElement(By.cssSelector("#reg_username")).sendKeys("ank2444");
        driver.findElement(By.cssSelector("#reg_email")).sendKeys("jacky266@imail.com");
        driver.findElement(By.cssSelector("#reg_password")).sendKeys("Sunday@1234");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[value='Register']")).click();

        driver.quit();*/
    }


   // @Test

    public void loginAccount() throws InterruptedException {

        getDriver().findElement(By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(getDriver().findElement(By.xpath("//h2[normalize-space()='Login']")).getText(),
                "Login"
        );


        getDriver().findElement(By.cssSelector("#username")).sendKeys("Ullu");
        getDriver().findElement(By.cssSelector("#password")).sendKeys("Sunday@1234");
        getDriver().findElement(By.cssSelector("button[value='Log in']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("li[id='menu-item-1226'] a[class='menu-link']")).click();
        getDriver().quit();
    }

 //   @Test
    public void AddedtoCart() throws InterruptedException
    {


        Billinginformation billinginformation=new Billinginformation();
        billinginformation.setFirstname("Ankit");
        billinginformation.setLastname("Jain");
        billinginformation.setCity("Noida");
        billinginformation.setAddressLineone("Noida blue cross society");
        billinginformation.setEmail("askomch233@gmail.com");
        billinginformation.setPostcode("91488");
        HomePage homePage =new HomePage(getDriver());
        StorePage storePage=homePage.ClickstoreMenuPage();
   storePage.
           /*EnterTextEarchField("Bracelet")
          .clickSearchBTn().
           gettitle();*/
                 search("Bracelet");
   Assert.assertEquals( storePage.gettitle(),"Search results: “Bracelet”");

   storePage.addToCart("Boho Bangle Bracelet");
           Thread.sleep(1000);
       // storePage.viewCart();
        cartPage cartpage=storePage.viewCart();
   Assert.assertEquals( cartpage.checkCartProduct(),"Boho Bangle Bracelet");
   checkoutPage checkoutpage=  cartpage.checkoutMethod();
   checkoutpage.
           setFirstName("Ankit").
           setLastName("Jain").
           setCompany("DELL").
           setBilliingAddress1("NSEZ Noida").
           setBilliingCity("Noida").
           setBillingPostcode("94188").
           setbillingEmail("jain244@gmail.com");
   Thread.sleep(5000);
        checkoutpage.setPlaceOrder();
        Thread.sleep(5000);
   Assert.assertEquals(checkoutpage.setTextValidation(),"Thank you. Your order has been received.");



/*

 driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
 driver.findElement(By.cssSelector("[class='search-field']")).sendKeys("Bracelet");
 driver.findElement(By.cssSelector("button[value='Search']")).click();


        System.out.println(driver.findElement(By.cssSelector("[class='woocommerce-products-header__title page-title']")).getText());

        Assert.assertEquals(driver.findElement(By.cssSelector("[class$='title page-title']")).getText(),
                "Search results: “Bracelet”"

        );
        System.out.println("Before View Cart");

       // driver.findElement(By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']")).click();
        driver.findElement(By.cssSelector("a[aria-label='Add “Boho Bangle Bracelet” to your cart']")).click();
        //driver.findElement(By.cssSelector(".added_to_cart")).click();



        //driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] a[class='button wc-forward']"));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();


        System.out.println(driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] span[class='count']")).getText());
        //driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] span[class='count']")).click();

       Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Boho Bangle Bracelet"

        );

 driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
 driver.findElement(By.cssSelector("#billing_first_name")).sendKeys(" Arina ");
 driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Jain");
 driver.findElement(By.cssSelector("#billing_company")).sendKeys("AltaVista");
 // driver.findElement(By.cssSelector("#select2-billing_country-container")).sendKeys("AltaVista");
 driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("Chaintanya Sadan");
driver.findElement(By.cssSelector("#billing_city")).sendKeys("Udaipur");
driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94188");
driver.findElement(By.cssSelector("#billing_email")).sendKeys("ank255@gmail.com");
        Thread.sleep(5000);
driver.findElement(By.cssSelector("[name='woocommerce_checkout_place_order'][id='place_order']")).click();

driver.findElement(By.cssSelector("[class='wp-block-group alignfull']")).click();
        Thread.sleep(5000);
Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
        "Thank you. Your order has been received."


);



        System.out.println("Done");

        //driver.close();

        driver.quit();  */

    }





//@Test
    public void loginAndLogoutDirectBankAccountTransfer() throws IOException {

   /* Billinginformation billinginformation=new Billinginformation();
    billinginformation.
            setFirstname("Ankit").
            setLastname("Jain").
            setCity("Noida").
            setAddressLineone("Noida blue cross society").
            setEmail("askomch233@gmail.com").
            setPostcode("91488").
            setCompany("DELl");*/

   // Billinginformation billinginformation=new Billinginformation("Ankit","Jain","blue corss society noida","Noida","94188","ank2553@gmail.com","ntt");

    Billinginformation billinginformation=JacksonUtils.Fileloader("SamppleDataFile.json",Billinginformation.class);
//JacksonUtils jacksonUtils=new JacksonUtils();

    //Products product=new Products(1199);
   // Userdetail userdetail=new Userdetail("","")
    StorePage storePage =new HomePage(getDriver()).load()
            .ClickstoreMenuPage()
            .search("Bracelet");
    Assert.assertEquals( storePage.gettitle(),"Search results: “Bracelet”");


    storePage.addToCart("Boho Bangle Bracelet");
   //  Thread.sleep(5000); //------added Implicit Wait in driver manager
    // storePage.viewCart();
    cartPage cartpage=storePage.viewCart();
    Assert.assertEquals( cartpage.checkCartProduct(),"Boho Bangle Bracelet" );
    checkoutPage checkoutpage=  cartpage.checkoutMethod();
   loginPage loginpage= checkoutpage.login();
   //loginpage.setUsername("Ullu").setPassword("Sunday@1234").clikLogin();
   loginpage.clikLogin("Ullu","Sunday@1234");
    checkoutpage.setBillinginformation(billinginformation);
          /*  setFirstName("Ankit").
            setLastName("Jain").
            setCompany("DELL").
            setBilliingAddress1("NSEZ Noida").
            setBilliingCity("Noida").
            setBillingPostcode("94188").
            setbillingEmail("jain244@gmail.com");*/
    //Thread.sleep(5000); //------added Implicit Wait in driver manager
    checkoutpage.setPlaceOrder();
  //   Thread.sleep(5000); //------added Implicit Wait in driver manager
    Assert.assertEquals(checkoutpage.setTextValidation(),"Thank you. Your order has been received.");

/*




    driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.findElement(By.cssSelector("[class='search-field']")).sendKeys("Bracelet");
        driver.findElement(By.cssSelector("button[value='Search']")).click();


        System.out.println(driver.findElement(By.cssSelector("[class='woocommerce-products-header__title page-title']")).getText());

        Assert.assertEquals(driver.findElement(By.cssSelector("[class$='title page-title']")).getText(),
                "Search results: “Bracelet”"

        );
        System.out.println("Before View Cart");

        driver.findElement(By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']")).click();
        //driver.findElement(By.cssSelector(".added_to_cart")).click();



        //driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] a[class='button wc-forward']"));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] span[class='count']")).getText());
        //driver.findElement(By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] span[class='count']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Boho Bangle Bracelet"

        );

        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        driver.findElement(By.cssSelector(".showlogin")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#username")).sendKeys("Ullu");
        driver.findElement(By.cssSelector("#password")).sendKeys("Sunday@1234");
        driver.findElement(By.cssSelector("button[value='Login']")).click();
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys(" Arina ");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Jain");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("AltaVista");
        // driver.findElement(By.cssSelector("#select2-billing_country-container")).sendKeys("AltaVista");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("Chaintanya Sadan");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("Udaipur");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94188");
   //     driver.findElement(By.cssSelector("#billing_email")).sendKeys("ank255@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[name='woocommerce_checkout_place_order'][id='place_order']")).click();

        driver.findElement(By.cssSelector("[class='wp-block-group alignfull']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."


        );



        System.out.println("Done");

        //driver.close();

        driver.quit();
*/
    }





    @Test
    public void CheckoutDirectBankAccountTransfer() throws IOException
    {


        Billinginformation billinginformation=JacksonUtils.Fileloader("SamppleDataFile.json",Billinginformation.class);
        //Products product=new Products(1199);
        StorePage storePage =new HomePage(getDriver()).load()

                .ClickstoreMenuPage();
        storePage.pageLoaded();

           storePage.search("Bracelet");

       Assert.assertEquals( storePage.gettitle(),"Search results: “Bracelet”");
        //Assert.assertTrue(storePage.gettitle().contains("Search results") );
        storePage.addToCart("Boho Bangle Bracelet");
       // Thread.sleep(5000); //------added Implicit Wait in driver manager
         cartPage cartpage=storePage.viewCart();

        Assert.assertEquals( cartpage.checkCartProduct(),"Boho Bangle Bracelet" );
        checkoutPage checkoutpage=  cartpage.checkoutMethod();
        loginPage loginpage= checkoutpage.login();
            loginpage.clikLogin("ank2557","xain@34567568");
//Thread.sleep(5000);
        checkoutpage.setBillinginformation(billinginformation);
       // Thread.sleep(5000); //------added Implicit Wait in driver manager
        checkoutpage.setPlaceOrder();
       // Thread.sleep(5000); //------added Implicit Wait in driver manager
        Assert.assertEquals(checkoutpage.setTextValidation(),"Thank you. Your order has been received.");







    }


//@Test
    public void CheckoutDirectBankAccountTransfer2() throws IOException
    {


        Billinginformation billinginformation=JacksonUtils.Fileloader("SamppleDataFile.json",Billinginformation.class);
        //Products product=new Products(1199);
        StorePage storePage =new HomePage(getDriver()).load()

                .ClickstoreMenuPage();
        storePage.pageLoaded();

        storePage.search("Bracelet");

        Assert.assertEquals( storePage.gettitle(),"Search results: “Bracelet”");
        //Assert.assertTrue(storePage.gettitle().contains("Search results") );
        storePage.addToCart("Boho Bangle Bracelet");
        // Thread.sleep(5000); //------added Implicit Wait in driver manager
        cartPage cartpage=storePage.viewCart();

        Assert.assertEquals( cartpage.checkCartProduct(),"Boho Bangle Bracelet" );
        checkoutPage checkoutpage=  cartpage.checkoutMethod();
        loginPage loginpage= checkoutpage.login();
        loginpage.clikLogin("ank2557","xain@34567568");
//Thread.sleep(5000);
        checkoutpage.setBillinginformation(billinginformation);
        // Thread.sleep(5000); //------added Implicit Wait in driver manager
        checkoutpage.setPlaceOrder();
        // Thread.sleep(5000); //------added Implicit Wait in driver manager
        Assert.assertEquals(checkoutpage.setTextValidation(),"Thank you. Your order has been received.");







    }





}
