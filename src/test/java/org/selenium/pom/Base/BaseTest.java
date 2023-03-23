package org.selenium.pom.Base;

import org.selenium.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest  {


   // protected static WebDriver driver=null;

    protected ThreadLocal<WebDriver>Thrd= new ThreadLocal<>();



    public void  setDriver(WebDriver driver)
    {
        this.Thrd.set(driver);
    }


    public  WebDriver  getDriver()
    {

        return  this.Thrd.get();
    }




    @Parameters("browser")
    @BeforeMethod
public void startDriver(String browser)
{

    setDriver(new DriverManager().InitializeDriver(browser));

    System.out.println("CURRENT THREAD  "+ "==="+Thread.currentThread().getName()+", "+
            "CURRENT DRIVER"+ getDriver());
  //  driver.get("http://askomdch.com");
    getDriver().manage().window().maximize();

}

@AfterMethod
public void quitDriver()
{
    System.out.println("CURRENT THREAD  "+ "==="+Thread.currentThread().getName()+", "+
            "CURRENT DRIVER"+ getDriver());
    getDriver().quit();
}

}
