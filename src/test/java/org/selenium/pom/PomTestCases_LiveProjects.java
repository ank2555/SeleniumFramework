/*
package org.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PomTestCases_LiveProjects extends BaseTest
{






   // @BeforeSuite
    public  void webDriver()
    {
        //     System.setProperty("webdriver.chrome.driver","/Users/ank255/Downloads/chromedriver");
        //  WebDriver driver=new ChromeDriver();
        // WebDriver driver=new ChromeDriver();
        //  WebDriver driver=new SafariDriver();

      WebDriver driver = new FirefoxDriver();

        driver.get("http://askomdch.com");
        driver.manage().window().maximize();

    }

   // @AfterSuite
    public void quitSuite()
    {
        getDriver().quit();
    }



   // @Test
    public void AccountCreation() throws InterruptedException {

        getDriver().findElement(By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(getDriver().findElement(By.xpath("//h2[normalize-space()='Register']")).getText(),
                "Register"
        );
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("#reg_username")).sendKeys("Ullu");
        getDriver().findElement(By.cssSelector("#reg_email")).sendKeys("jacky255@imail.com");
        driver.findElement(By.cssSelector("#reg_password")).sendKeys("Sunday@1234");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[value='Register']")).click();

        driver.quit();
    }


   // @Test

    public void loginAccount() throws InterruptedException {

        driver.findElement(By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText(),
                "Login"
        );


        driver.findElement(By.cssSelector("#username")).sendKeys("Ullu");
        driver.findElement(By.cssSelector("#password")).sendKeys("Sunday@1234");
        driver.findElement(By.cssSelector("button[value='Log in']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("li[id='menu-item-1226'] a[class='menu-link']")).click();
        driver.quit();
    }

   // @Test
    public void AddedtoCart() throws InterruptedException {




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

        driver.quit();

    }





  //  @Test
    public void loginAndLogoutDirectBankAccountTransfer() throws InterruptedException {




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



    }

}


*/
