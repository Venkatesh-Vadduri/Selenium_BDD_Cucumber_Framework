package com.stepDef;

import com.base.BaseClass;
import com.pages.AccountSuccessPage;
import com.pages.HomePage;
import com.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MyStepdefs {

    HomePage homepg ;
    RegisterPage registerpg;


    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        homepg = new HomePage(BaseClass.getDriver());
        homepg.clickMyAccountDropdown();
        homepg.clickLoginOption();
    }

    @Given("User enters invalid email address into email field")
    public void userEntersInvalidEmailAddressIntoEmailField() {

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
        registerpg.enterEmail("abctest@gmail.com");
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
        AccountSuccessPage actSucpg = new AccountSuccessPage(BaseClass.getDriver());
        Assert.assertEquals(actSucpg.getPageHeading(), "Your Account Has Been Created!");
        Assert.assertEquals(actSucpg.getPageHeading1(), "Congratulations! Your new account has been successfully created!");
        Assert.assertEquals(actSucpg.getPageHeading2(), "You can now take advantage of member privileges to enhance your online shopping experience with us.");
        Assert.assertEquals(actSucpg.getPageHeading3(), "If you have ANY questions about the operation of this online shop, please e-mail the store owner.");

    }
}
