package org.selenium.pom.Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.selenium.pom.utils.FrameworkUtility.readConfigurationFile;

public class BasePage extends BaseTest {


    protected WebDriver driver;
    String BaseURL;
    protected WebDriverWait waitShort;
    protected WebDriverWait waitLong;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        waitLong = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitShort = new WebDriverWait(driver, Duration.ofSeconds(15));


    }


    public BasePage loadpage(String endpoint) {

        BaseURL = readConfigurationFile("baseUrl");
        driver.get(BaseURL + endpoint);
        return this;
    }

    public void waitForOverlaytoDisappear(By overlay) {
        List<WebElement> overlays = (List<WebElement>) driver.findElements(overlay);
        System.out.println("ovelays objects are " + overlays);

        if (overlays.size() > 0) {
            System.out.println("ovelays objects are " + overlays.size());

            //waitLong.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            // waitShort.until(ExpectedConditions.invisibilityOfAllElements(overlays));

            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(overlays));


        } else {
            System.out.println("No Overlays Found ");
        }
    }


    public WebElement webElementToBeClickable(By element) {
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement webElementToBeVisible(By element) {
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public String webElementAlertisPresent(By element) {

        driver.findElement(element).click();
        Alert alert = waitShort.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        String alertString = alert.getText();
        alert.accept();
        return alertString;
    }

    public void webElementAlertisPresent() {


        Alert alert = waitShort.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        String alertString = alert.getText();
        alert.accept();

    }

    public String webElementAlertSendValue(By element, String Name) {

        driver.findElement(element).click();
        Alert alert = waitShort.until(ExpectedConditions.alertIsPresent());
        String alertString = driver.switchTo().alert().getText();

        driver.switchTo().alert().sendKeys(Name);
        alert.accept();
        return alertString;
    }


}
