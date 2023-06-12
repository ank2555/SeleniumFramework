package org.selenium.pom.Base;

import io.netty.util.Constant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.Constant.FrameworkConstants;
import org.selenium.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.selenium.pom.utils.FrameworkUtility.readConfigurationFile;

public class BaseTest  {


    protected static WebDriver driver=null;

    private  String browser;
  //  protected ThreadLocal<WebDriver>Thrd= new ThreadLocal<>();



    public void  setDriver(WebDriver driver)
    {
        //this.Thrd.set(driver);
        this.driver=driver;
    }


    public  WebDriver  getDriver()
    {

       // return  this.Thrd.get();
        return  driver;
    }




    //@Parameters("browser")
@BeforeMethod
public void startDriver(@Optional String browser)
{
    //browser="FIREFOX";
   //browser=ConfigLoader.getinstance().getBrowser();
    browser=readConfigurationFile("browser");
    System.out.println(browser);
    //browser = Props.getProp("browser");
    setDriver(new DriverManager().InitializeDriver(browser));

   // System.out.println("CURRENT THREAD  "+ "==="+Thread.currentThread().getName()+", "+ "CURRENT DRIVER"+ getDriver());
  //  driver.get("http://askomdch.com");
    getDriver().manage().window().maximize();

}

@AfterMethod
public void quitDriver(@Optional String Browser, ITestResult result) throws IOException {
    //System.out.println("CURRENT THREAD  "+ "==="+Thread.currentThread().getName()+", "+ "CURRENT DRIVER"+ getDriver());

    browser=readConfigurationFile("browser");
    File DestFiles = null;
    if (result.getStatus() == ITestResult.FAILURE) {
        //File destFile=new File("/Users/ank255/Downloads/Study Projects/Project_Study_selenium/target/Screenshots"+".png");

        DestFiles = new File(FrameworkConstants.SCREENSHOTS + File.separator + browser + File.separator +"FAILURE"+File.separator+ result.getTestClass().getRealClass().getSimpleName()  +
                File.separator + result.getMethod().getMethodName() + ".png");
        takeScreenShot(DestFiles);

    }


    if (result.getStatus() == ITestResult.SUCCESS) {
        //File destFile=new File("/Users/ank255/Downloads/Study Projects/Project_Study_selenium/target/Screenshots"+".png");

        DestFiles = new File(FrameworkConstants.SCREENSHOTS + File.separator + browser + File.separator +"SUCCESS"+File.separator+ result.getTestClass().getRealClass().getSimpleName()  +
                File.separator + result.getMethod().getMethodName() + ".png");
        takeScreenShot(DestFiles);
        takeFullscreenshotashot(DestFiles);
    }


    getDriver().quit();
}


public  void  takeScreenShot(File DestFiles) throws IOException
{

    TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();


    File SrcFile =takesScreenshot.getScreenshotAs(OutputType.FILE);

    FileUtils.copyFile(SrcFile,DestFiles);
}



public void  takeFullscreenshotashot(File DestFiles) throws IOException {
    Screenshot screenshot= new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(100))
            .takeScreenshot(getDriver());

    ImageIO.write(screenshot.getImage(),"JPG",DestFiles);
}




}
