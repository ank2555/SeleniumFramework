package org.selenium.pom.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.selenium.pom.utils.FrameworkUtility.readConfigurationFile;

public class Test2 extends BaseTest {

    public WebDriver driver;

    protected final By alertelement = By.xpath("//input[@id='alert1']");
    private final By getPromptElement = By.xpath("//input[@id='prompt']");

    @Test
    public void Alert() throws InterruptedException {


        String browser = readConfigurationFile("browser");
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        Thread.sleep(300);

        //   basePage.getDriver().findElement(alertelement).click();
        String AlretString = basePage.webElementAlertisPresent(alertelement);
        Assert.assertEquals(AlretString, "Hello");
   /*driver=getDriver();
    WebDriverWait webDriverWait=new WebDriverWait(driver,30);
   Alert alert= webDriverWait.until(ExpectedConditions.alertIsPresent());


   alert.accept();*/


    }

    @Test
    public void AlertSendValue() throws IOException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");


  /* driver=getDriver();
  driver.findElement(getPromptElement).click();
     WebDriverWait webDriverWait=new WebDriverWait(driver,30);
     Alert alert= webDriverWait.until(ExpectedConditions.alertIsPresent());
     System.out.println(alert.getText());
       basePage.getDriver().switchTo().alert().sendKeys("Ankit");
     */

        String AlretString = basePage.webElementAlertSendValue(getPromptElement, "AnkitJain");
        Assert.assertEquals(AlretString, "What is your name?");

   /*  TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
    File destFile=new File("/Users/ank255/Downloads/Study Projects/Project_Study_selenium/target/Screenshots"+".png");

     File SrcFile =takesScreenshot.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(SrcFile,destFile);*/


    }


    @Test
    public void Cookie() {


        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        getDriver().findElement(By.cssSelector("button[title='Allow essential and optional cookies'][type='submit']")).click();
        getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("ankitjain19@ibibo.com");
        getDriver().findElement(By.xpath("//input[@id='pass']")).sendKeys("Krystal@255");

        getDriver().findElement(By.cssSelector("button[name='login'][data-testid='royal_login_button']")).click();

        System.out.println(basePage.getDriver().manage().getCookies());
        Set<Cookie> cookies = basePage.getDriver().manage().getCookies();


        for (Cookie cookie : cookies) {
            System.out.println(cookie.getValue());
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getExpiry());


        }


    }


    @Test
    public void SwitchWindows() {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");


        driver = getDriver();
        String Firstwindow = driver.getWindowHandle();
        System.out.println(Firstwindow);

        driver.switchTo().window(Firstwindow);

        driver.findElement(By.linkText("Open a popup window")).click();
        Set<String> windows = driver.getWindowHandles();

        for (Object s : windows) {
            if (driver.getTitle().equals("Basic Web Page Title")) {
                driver.close();
            }
        }

        System.out.println(windows.size());
        System.out.println(windows.iterator());
        Iterator<String> itr = windows.iterator();
        System.out.println(itr.hasNext());
        while (itr.hasNext()) {
            String window = itr.next();

            driver.switchTo().window(window);
            if (driver.getTitle().equals("Basic Web Page Title")) {

            }

            driver.switchTo().window(Firstwindow);
            driver.findElement(By.name("q")).sendKeys("sssssss");
            driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();

        }


    }

    @Test
    public void find_element() {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");

        driver = getDriver();
        driver.findElement(By.cssSelector("textarea[id='ta1']")).sendKeys("Hi this is Ankit Jaindccffffvfrvrvrvrvrvrvrvrvrrrcrcrsdkdnsbbabbdjbhbdhbdshbdsh " +
                "dshdjbd dshjd hj dsh dshj dshd dcdn jdsbcjbjhvchjdsbchejvchdv c" +
                "dscbdsjbdjbjhbvdhvdhjcvbhcbvdhvdhjvdhjvdc" +
                "dscndjsbcjdsbjhdbhjdvhjvcheje" +
                "kdbcdsbjdbjhcvbchjvhevhjevhevhjevc" +
                "dscbdsjvehjcvehjcvehjvehjvehcvehvehjcesh dsh d");
        driver.findElement(By.cssSelector("textarea[id='ta1']")).clear();
        driver.findElement(By.cssSelector("textarea[id='ta1']")).sendKeys("Jain");
    }

    @Test
    public void partial_link_text() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        driver.findElement(By.partialLinkText("automatedtest")).click();
    }

    @Test
    public void cleattextBox() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        String text = driver.findElement(By.xpath("//input[@id='textbox1']")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//input[@id='textbox1']")).clear();
    }

    @Test
    public void getTitle() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.close();

    }

    @Test
    public void close() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        driver.findElement(By.xpath("//a[normalize-space()='Open a popup window']")).click();


        driver.close();

    }


    @Test
    public void getAttribute() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        String textbutton = driver.findElement(By.cssSelector("input[value='Search']")).getAttribute("value");
        System.out.println(textbutton);

    }

    @Test
    public void isDiplayed() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        System.out.println(driver.findElement(By.cssSelector("input[value='Search']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Hidden Button']")).isDisplayed());

    }

    @Test
    public void isEnabled() throws IOException {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        System.out.println(driver.findElement(By.cssSelector("button[id='but2'][type='button']")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("button[id='but1'][type='button']")).isEnabled());


    }


    @Test
    public void getPageSource() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        String pagesoruce = driver.getPageSource();

        File file = new File("/Users/ank255/Downloads/Study Projects/Project_Study_selenium/target/Screenshots/firefox/SUCCESS/Test2/abc.text");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(pagesoruce);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void Submit() {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ankit.jain19@ibibo.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Krystal@255");
        driver.findElement(By.xpath("//input[@id='pass']")).submit();


    }

    @Test
    public void Nabigate() {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        driver.navigate().to("http://Google.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }


    @Test
    public void DeleteCookies() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ankitjain19@ibibo.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Krystal@255");
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='pass']")).submit();
        // driver.findElement(By.cssSelector("button[name='login'][type='submit']")).click();

        driver.navigate().refresh();
    }


    @Test
    public void Cookies() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getName());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getValue());
            ;
        }
    }


    @Test
    public void addCookies() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        Cookie cookie = new Cookie("Jain", "djbjcbjbjbsj");
        driver.manage().addCookie(cookie);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookiee : cookies) {
            System.out.println(cookiee.getName());
            System.out.println(cookiee.getPath());
            System.out.println(cookiee.getName());
            System.out.println(cookiee.getExpiry());
            System.out.println(cookiee.getValue());
            ;
        }


    }


    @Test
    public void getCookiesNaemd() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        System.out.println(driver.manage().getCookieNamed("OCSESSID"));
        driver.manage().deleteCookieNamed("OCSESSID");
        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
        }


    }


    @Test
    public void javaScriptCommand() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Hi');");
        Thread.sleep(2000);


    }


    @Test
    public void Perfom() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        WebElement blogmenu = driver.findElement(By.xpath("//span[@id='blogsmenu']"));

        Actions actions = new Actions(driver);
        //actions.moveToElement(blogmenu).perform();
        //actions.doubleClick(blogmenu);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Ankit");
        WebElement searchtextBox = driver.findElement(By.xpath("//input[@name='q']"));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();


    }

    @Test
    public void windows() throws InterruptedException {
        BasePage basePage = new BasePage(getDriver()).loadpage("/");
        driver = getDriver();

        String window1 = driver.getWindowHandle();
        driver.findElement(By.linkText("Open a popup window")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();

        while (iterator.hasNext()) {
            String windolist = iterator.next();
            driver.switchTo().window(windolist);
            if (driver.getTitle().equals("Basic Web Page Title")) {
                driver.close();
            }

        }
        driver.switchTo().window(window1);
    }


    @Test
    public void alert() {

        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();

        driver.findElement(By.xpath("//input[@id='alert1']")).click();
      Alert alert=  driver.switchTo().alert();
        System.out.println(alert.getText());
    // alert.accept();
        alert.dismiss();

    }

    @Test
    public void alert_sendkeys() {

        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();

        driver.findElement(By.xpath("//input[@id='prompt']")).click();
        Alert alert=  driver.switchTo().alert();
        System.out.println(alert.getText());
        // alert.accept();
        alert.sendKeys("Ankit");
        //alert.accept();

    }



    @Test
    public void Invisibilyt_elelement() {

        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();

    //    driver.findElement(By.xpath("//div[@id='deletesuccess']")).click();;
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(26));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='deletesuccess']")));
        driver.findElement(By.xpath("//input[@id='alert2']")).click();

        Alert alert=  driver.switchTo().alert();
        System.out.println(alert.getText());
        // alert.accept();
       // alert.sendKeys("Ankit");
        alert.accept();

    }



    @Test
    public  void elementtoBeClickable()
    {
        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();

        driver.findElement(By.xpath("//button[normalize-space()='Check this']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dte']"))).click();
       // driver.switchTo().alert().accept();

    }

    @Test
    public  void implicitWait()
    {
        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.className("dropbtn")).click();
        driver.findElement(By.cssSelector("a[href='http://facebook.com']")).click();


    }

    @Test
    public  void DropDown()
    {
        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();
   WebElement dropDown=  driver.findElement(By.id("multiselect1"));
        Select select=new Select(dropDown);
        System.out.println(select.isMultiple());



    }



    @Test
    public  void getAllSelectedOptions()
    {
        new BasePage(getDriver()).loadpage("/");
        driver=getDriver();
        WebElement Multiselect =  driver.findElement(By.id("multiselect1"));
        Select select=new Select(Multiselect);

        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Hyundai");
        select.selectByVisibleText("Audi");

        List<WebElement> selectedoption = select.getAllSelectedOptions();



        for (WebElement selectvalue:selectedoption)
        {
            System.out.println(selectvalue.getText());
        }





    }


    @Test
    public  void DeSelection() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
        WebElement Multiselect = driver.findElement(By.id("multiselect1"));
        Select select = new Select(Multiselect);

        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Hyundai");
        select.selectByVisibleText("Audi");
        select.deselectByVisibleText("Audi");
        List<WebElement> selectedoption = select.getAllSelectedOptions();


        for (WebElement selectvalue : selectedoption) {
            System.out.println(selectvalue.getText());
        }
    }


    @Test
    public  void Frame() {
        new BasePage(getDriver()).loadpage("/");
        driver = getDriver();
WebElement frame=driver.findElement(By.id("iframe2"));

driver.switchTo().frame(frame);

driver.findElement(By.id("Chapter3")).click();

    }







@Test
public  void DragenDropBy() {
        new BasePage(getDriver()).loadpage("/p/page3.html");
        driver = getDriver();
     WebElement priceoption=  driver.findElement(By.cssSelector("a[class='ui-slider-handle ui-btn ui-shadow ui-btn-null']"));
     Actions actions=new Actions(driver);

     actions.dragAndDropBy(priceoption,200,0).build().perform();

        }





    @Test
    public  void DragenDrop() {
        new BasePage(getDriver()).loadpage("html");
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Box1Source=  driver.findElement(By.id("box5"));
        WebElement BoxTarget=driver.findElement(By.xpath("//div[@id='box103']"));
        Actions actions=new Actions(driver);
actions.dragAndDrop(Box1Source,BoxTarget).build().perform();

    }

}