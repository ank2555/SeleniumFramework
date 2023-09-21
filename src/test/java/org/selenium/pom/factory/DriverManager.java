package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.constants.DriverType;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.Props;

public class DriverManager {

    public WebDriver InitializeDriver(String browser) {

        WebDriver driver;
        //  System.getProperty("browser");
        //browser = Props.getProp("browser");
        System.out.println(browser);
        // Props.getProp("browser");
        switch (browser.toLowerCase()) {
            case ("firefox") -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }

            case ("chrome") -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case ("safari") -> {
                WebDriverManager.safaridriver().cachePath("Drivers").setup();
                driver = new SafariDriver();
            }


            default -> throw new IllegalStateException("Invalid browser Name:" + browser);
        }


        //System.setProperty("webdriver.chrome.driver","/Users/ank255/Downloads/chromedriver");
        //  WebDriver driver=new ChromeDriver()
        //  WebDriver driver=new ChromeDriver();
        //   WebDriver driver=new SafariDriver();

        //   WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        //   WebDriverManager.chromedriver().cachePath("Drivers").setup();

        /*
   WebDriver   driver = new FirefoxDriver();
   //    WebDriver driver=new ChromeDriver();


         //driver.get("http://askomdch.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

*/
        //Dimension d=new Dimension(50,50);
        //driver.manage().window().fullscreen();

        return driver;


    }
}
