package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.constants.DriverType;

public class DriverManager {

    public WebDriver InitializeDriver(String  browser)
    {

        WebDriver driver;

        switch (DriverType.valueOf(browser))
        {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().cachePath("Drivers").setup();
                driver = new SafariDriver();
            }
            default -> throw new IllegalStateException("Invalid browser Name:" + browser);
        }


         // System.setProperty("webdriver.chrome.driver","/Users/ank255/Downloads/chromedriver");
        //  WebDriver driver=new ChromeDriver()
        //  WebDriver driver=new ChromeDriver();
        //   WebDriver driver=new SafariDriver();

        //   WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
    //   WebDriverManager.chromedriver().cachePath("Drivers").setup();

        /*
   WebDriver   driver = new FirefoxDriver();
   //    WebDriver driver=new ChromeDriver();


         //driver.get("http://askomdch.com");
           driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

*/

return driver;


    }
}
