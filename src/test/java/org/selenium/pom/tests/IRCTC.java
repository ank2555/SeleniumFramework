package org.selenium.pom.tests;

import com.simtechdata.FixTess4j4Mac;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.Base.BasePage;
import org.openqa.selenium.io.FileHandler;
import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.Constant.FrameworkConstants;
import org.selenium.pom.utils.TextImage;
import org.testng.annotations.Test;

import java.io.IOException;


import java.io.File;
import java.time.Duration;
import java.util.List;


import static org.selenium.pom.utils.FrameworkUtility.readConfigurationFile;

public class IRCTC extends BaseTest {

    protected final By alertelement = By.xpath("//input[@id='alert1']");
    protected final By loginButton = By.cssSelector("a[aria-label='Click here to Login in application'][class='search_btn loginText ng-star-inserted']");
    protected final By username = By.cssSelector("input[formcontrolname='userid'][placeholder='User Name']");
    protected final By password = By.cssSelector("input[type='password'][formcontrolname='password'][placeholder='Password']");
    protected final By captchaimg = By.cssSelector("img[class='captcha-img']");
    protected final By EnterCaptcha = By.cssSelector("input[placeholder='Enter Captcha']");
    //protected  final  By SIGNIN=By.xpath("//button[normalize-space()='SIGN IN']]");
    protected final By SIGNIN = By.cssSelector("button[type='submit'][class='search_btn train_Search']");
    protected final By From = By.cssSelector("input[class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted'][role='searchbox']");
    //protected  final  By To_list=By.xpath("//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']");
    protected final By To_list = By.cssSelector("input[class='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted'][role='searchbox']");
    protected final By SelectClass = By.xpath("//span[@class='ng-tns-c65-12 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");

    protected final By SearchButton = By.cssSelector("button[type='submit'][label='Find Trains']");

    protected final By SelectDate=By.cssSelector("input[type='text'][class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']");

    @Test
    public void loginAccount() throws InterruptedException, IOException, TesseractException {
        {

            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-notifications");

            BasePage basePage = new BasePage(getDriver()).loadpage("/");
            //   basePage.webElementAlertisPresent();
            basePage.webElementToBeClickable(loginButton);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            getDriver().findElement(loginButton).click();
            basePage.webElementToBeVisible(username);
//            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='userid'][placeholder='User Name']"))).click();


            getDriver().findElement(username).click();
            getDriver().findElement(username).clear();
            getDriver().findElement(username).sendKeys("ankit2555");
            getDriver().findElement(password).clear();
            getDriver().findElement(password).sendKeys("Krystal@255");
            basePage.webElementToBeVisible(captchaimg);

            File src = getDriver().findElement(captchaimg).getScreenshotAs(OutputType.FILE);
            File DestFiles = new File(FrameworkConstants.CAPTCHA + File.separator +
                    File.separator + "captcha.png");

            FileHandler.copy(src, DestFiles);
            ITesseract tesseract = new Tesseract();
            // Tesseract tesseract = new Tesseract();
            //   tesseract.setDatapath(FixTess4j4Mac.getDataPath());

            tesseract.setDatapath("/opt/homebrew/Cellar/tesseract/5.3.2_1/share/tessdata");
            tesseract.setLanguage("eng");

            String imageText = "";

            if (DestFiles.exists()) {

                imageText = tesseract.doOCR(DestFiles);
                System.out.println(imageText);

            } else {
                Thread.sleep(3000);
                imageText = tesseract.doOCR(DestFiles);
                System.out.println(imageText);

            }


            getDriver().findElement(EnterCaptcha).sendKeys(imageText);
            basePage.webElementToBeClickable(SIGNIN);
            getDriver().findElement(SIGNIN).click();

            Actions actions = new Actions(getDriver());
            WebElement fromlists = getDriver().findElement(From);
            getDriver().findElement(From).clear();


            actions.sendKeys(fromlists, "adi")
                    .keyDown(Keys.ARROW_DOWN)
                    .keyDown(Keys.ENTER).build().perform();
            WebElement To_lists = getDriver().findElement(To_list);

            getDriver().findElement(To_list).clear();
            actions.sendKeys(To_lists, "pune")
                    .keyDown(Keys.ARROW_DOWN)
                    .keyDown(Keys.ENTER).build().perform();


            WebElement dropdownField = getDriver().findElement(SelectClass);
            Select select1 = new Select(dropdownField);
            select1.selectByVisibleText("TATKAL");

            getDriver().findElement(SearchButton).click();


        }
    }


    @Test
    public void selectStation()

    {

        BasePage basePage = new BasePage(getDriver()).loadpage("/");
/*
         Actions actions = new Actions(getDriver());
        // basePage.webElementToBeClickable(From);

        WebElement fromlists=getDriver().findElement(From);
        getDriver().findElement(From).clear();

        actions.sendKeys(fromlists,"adi")
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER).build().perform();
        basePage.webElementToBeClickable(To_list);
        WebElement To_lists=getDriver().findElement(To_list);

        getDriver().findElement(To_list).clear();
        actions.sendKeys(To_lists,"pune")
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER).build().perform();

        basePage.webElementToBeClickable(SelectClass);
        WebElement dropdownField = getDriver().findElement(SelectClass);
        dropdownField.click();
        getDriver().findElement(By.cssSelector("li[role='option'][aria-label='LADIES']")).click();*/
        basePage.webElementToBeClickable(SelectDate);

        getDriver().findElement(SelectDate).click();
        List<WebElement> lst= getDriver().findElements(By.tagName("td"));
       // getDriver().findElement(By.tagName("td"));



       for (WebElement element:lst)
       {
           System.out.println(element.getText());
           if (element.equals("26"))
           {
               System.out.println(element.getText()+"djdkdkd");
               element.findElement(By.linkText("26")).click();
               break;

           }
       }



        //List<WebElement> lst =   dropdownField.findElements(By.cssSelector("li[role='option'][aria-label='TATKAL']"));

        /*
        Select select1 = new Select(dropdownField);


        List<WebElement> lst = select1.getOptions();
        System.out.println(lst.size() + "SIZE");

        for (WebElement element : lst)
        {
            System.out.println(element.getText());
        }
        select1.selectByValue("TATKAL");


        getDriver().findElement(SearchButton).click();


        //actions.moveToElement(fromlists).keyDown(Keys.ENTER).build().perform();
/*
        //actions.moveToElement(fromlists).build().perform();
        getDriver().findElement(To_list).clear();
        getDriver().findElement(From).sendKeys("pune");
        actions.moveToElement(fromlists).keyDown(Keys.ENTER).build().perform();

**/


    }


}


