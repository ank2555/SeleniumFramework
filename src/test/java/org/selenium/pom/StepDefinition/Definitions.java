package org.selenium.pom.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.Objects.AccountCreationUsers;
import org.selenium.pom.Pages.HomePage;
import org.selenium.pom.Pages.account;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;

import java.io.IOException;

public class Definitions extends BaseTest {


    @Given("^User is on Merchant Page$")
    public void NavigateMerchantPage() throws IOException {
        new HomePage(getDriver()).load();


    }


    @When("User Click on Account to Login$")

    public void AccountPage() {
        account account = new HomePage(getDriver()).load().AccountPage();
        //account account=new HomePage(getDriver()).AccountPage().ClickRegister(accountCreationUsers);


    }


    @And("^User provide all Account Detail to create Account on Login Page$")
    public void LoginPage() throws Throwable {
        System.out.println("Jain1");
        AccountCreationUsers accountCreationUsers = JacksonUtils.Fileloader("AccountUserdetails.json", AccountCreationUsers.class);
        account account = new HomePage(getDriver()).load().AccountPage();
        Assert.assertEquals(account.RegisterText(), "Register");

    }


    @And("^User click on Register$")
    public void Register() throws Throwable {
        System.out.println("Jain1");
        AccountCreationUsers accountCreationUsers = JacksonUtils.Fileloader("AccountUserdetails.json", AccountCreationUsers.class);
        account account = new HomePage(getDriver()).load().AccountPage();
        Assert.assertEquals(account.RegisterText(), "Register");
        account.ClickRegister(accountCreationUsers);
    }

    @Then("^Account Page is Displayed$")
    public void AccountLoginPage() throws Throwable {
        System.out.println("Jain1");
    }

}
