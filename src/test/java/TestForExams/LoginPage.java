package TestForExams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class LoginPage {

/*

    //WebDriver driver = new FirefoxDriver();
    WebDriver webDriver = new ChromeDriver();
       // driver.get("https://your login url");

     //   driver.manage().window().maximize();

//@BeforeMethod
public void  driverinitialization()
{
    webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

}


    //@AfterMethod
    public void  driverquit()
    {
        //driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        webDriver.quit();
    }




    @Test
    public void testLoginFormPresent()
    {
        // below you can find already setup webDriver
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        boolean Email=  webDriver.findElement(By.id("email-input")).isDisplayed();
        boolean password=  webDriver.findElement(By.id("password-input")).isDisplayed();
        boolean loginbutton=webDriver.findElement(By.id("login-button")).isDisplayed();

        System.out.println(Email);
        String text= webDriver.findElement(By.id("email-input")).getText();
        System.out.println(text);
        assert(Email==true);
        assert(password==true);
        assert(loginbutton==true);

        //Assert.assertEquals(webDriver.findElement(By.id("email-input")).getText(), "e-mail");





    }

    @Test
    public  void  validLoginCredentials()
    {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
  String welcompage=    webDriver.findElement(By.xpath("(//div[@class='message success'])[1]")).getText();
        System.out.println(welcompage);
 // assert(welcompage=="Welcome to Codility");

        assertEquals(welcompage,"Welcome to Codility");
     // driver.quit();
    }


    @Test
    public  void  InvalidLoginCredentials()
    {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility2.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        String welcompage=    webDriver.findElement(By.xpath("//div[@class='message error']")).getText();
        System.out.println(welcompage);
        // assert(welcompage=="Welcome to Codility");

        assertEquals(welcompage,"You shall not pass! Arr!");
        // driver.quit();
    }


    @Test
    public  void  InvalidEmail()
    {
        webDriver.findElement(By.id("email-input")).sendKeys("logincodility2.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        String welcompage=    webDriver.findElement(By.xpath("//div[@class='validation error']")).getText();
        System.out.println(welcompage);
        // assert(welcompage=="Welcome to Codility");

        assertEquals(welcompage,"Enter a valid email");
        // driver.quit();
    }



    @Test
    public  void  EmailRequired()
    {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("");
        webDriver.findElement(By.id("login-button")).click();
        String welcompage=    webDriver.findElement(By.xpath("//div[@class='validation error']")).getText();
        System.out.println(welcompage);
        // assert(welcompage=="Welcome to Codility");

        assertEquals(welcompage,"Password is required");
        // driver.quit();
    }

    @Test
    public  void  PasswordRequired()
    {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("");
        webDriver.findElement(By.id("login-button")).click();
        String welcompage=    webDriver.findElement(By.xpath("//div[@class='validation error']")).getText();
        System.out.println(welcompage);
        // assert(welcompage=="Welcome to Codility");

        assertEquals(welcompage,"Password is required");
        // driver.quit();
        // driver.quit();
    }
*/


    String Product = "";
    String P2 = null;

    String P3 = "a";

    @Test
    public String shouldInvert(String FName) {
        // this.FName=FName;
        //  assertNull(FName);
        return FName;


    }

    @Test
    public String NullMthod(String P2) {
        assertNull(P2);
        P2 = "";
        return P2;


    }

    @Test
    public String SingleChar(String P3) {

        String temp = "";
        //assertNull(P2);
        char[] line = P3.toCharArray();

        for (int i = 0; i < P3.length(); i++) {
            if (line.length == 1) {
                temp = P3;
            }
        }

        return temp;

    }


}
