package com.stepDef;

import com.base.BaseClass;
import com.pages.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MyStepdefs {

    HomePage homepg ;
    RegisterPage registerpg;
    AccountPage accountPg;
    AccountSuccessPage actSucpg;
    LoginPage loginPg;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        homepg = new HomePage(BaseClass.getDriver());
        homepg.clickMyAccountDropdown();
        homepg.clickLoginOption();
    }


    @Given("User navigates to Registration page")
    public void userNavigatesToRegistrationPage() {
        homepg = new HomePage(BaseClass.getDriver());
        homepg.clickMyAccountDropdown();
        homepg.clickRegisterOption();
        registerpg = new RegisterPage(BaseClass.getDriver());
    }

    @When("User enters details into below fields")
    public void userEntersDetailsIntoBelowFields() {
        registerpg.enterFirstName("Venkatesh");
        registerpg.enterLastName("Vadduri");
        registerpg.enterEmail(BaseClass.generateEmail());
        registerpg.enterPhone("1234567890");
        registerpg.enterPassword("Test@123");
        registerpg.enterConfirmPassword("Test@123");
    }

    @And("User selects Privacy Policy")
    public void userSelectsPrivacyPolicy() {
        registerpg.clickOnPolicyCheckBox();
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        registerpg.clickOnContinueButton();
    }

    @Then("User account should get created successfully")
    public void userAccountShouldGetCreatedSuccessfully() {
        actSucpg = new AccountSuccessPage(BaseClass.getDriver());
        Assert.assertEquals(actSucpg.getPageHeading(), "Your Account Has Been Created!");
        Assert.assertEquals(actSucpg.getPageHeading1(), "Congratulations! Your new account has been successfully created!");
        Assert.assertEquals(actSucpg.getPageHeading2(), "You can now take advantage of member privileges to enhance your online shopping experience with us.");
        Assert.assertEquals(actSucpg.getPageHeading3(), "If you have ANY questions about the operation of this online shop, please e-mail the store owner.");

    }

    @And("User selects Newsletter")
    public void userSelectsNewsletter() {
        registerpg.clickOnSubscribeYes();
    }

    @When("User do not enters details into below fields")
    public void userDoNotEntersDetailsIntoBelowFields() {
        registerpg.enterFirstName("");
        registerpg.enterLastName("");
        registerpg.enterEmail("");
        registerpg.enterPhone("");
        registerpg.enterPassword("");
        registerpg.enterConfirmPassword("");

    }

    @Then("User should get proper warning messages for every mandatory field")
    public void userShouldGetProperWarningMessagesForEveryMandatoryField() {
        registerpg.displayFirstNameWarning();
        registerpg.displayLastNameWarning();
        registerpg.displayEmailWarning();
        registerpg.displayPhoneWarning();
        registerpg.displayPasswordWarning();
        registerpg.displayPolicydWarning();

    }


    @And("User click on Subscribe unsubscribe Newsletter")
    public void userClickOnSubscribeUnsubscribeNewsletter() {
             accountPg = new AccountPage(BaseClass.getDriver());
             accountPg.clickOnNewsletter();
    }

    @Then("User click Continue button on Account Success page")
    public void userClickContinueButtonOnAccountSuccessPage() {
        actSucpg.clickOnContinueButtonInAccSuccessPage();

    }

    @Then("User should should See Newsletter subscribe Yes Option")
    public void userShouldShouldSeeNewsletterSubscribeYesOption() {
     actSucpg.getYesNewsLetterOption();
    }

    @Then("User should should See Newsletter subscribe NO Option")
    public void userShouldShouldSeeNewsletterSubscribeNOOption() {
        actSucpg.getNoNewsLetterOption();
    }

    @Given("User click on My Account Dropdown in the Home page")
    public void userClickOnMyAccountDropdownInTheHomePage() {
     homepg = new HomePage(BaseClass.getDriver());
     homepg.clickMyAccountDropdown();
    }

    @And("User click on Register Option in the Home page")
    public void userClickOnRegisterOptionInTheHomePage() {
       homepg.clickRegisterOption();
    }

    @And("User click on Login Option in the Home page")
    public void userClickOnLoginOptionInTheHomePage() {
      homepg.clickLoginOption();
    }


    @When("User clicks on Continue Button on New Customer page")
    public void userClicksOnContinueButtonOnNewCustomerPage() {
        loginPg = new LoginPage(BaseClass.getDriver());
        loginPg.clickonContinueButton();
    }

    @Then("User click on Register Option")
    public void userClickOnRegisterOption() {
       registerpg = new RegisterPage(BaseClass.getDriver());
       registerpg.clickOnRegisterOption();
    }

    @Then("User Able to See Register Account page")
    public void userAbleToSeeRegisterAccountPage() {
        registerpg.displayRegisterAccount();
    }
}
