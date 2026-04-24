package com.pages;

import com.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;
    public ActionDriver actionDriver;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver, this);
    }

    //Define Locators using Page Factory
    @FindBy(id = "input-firstname")
    private WebElement firstname;

    @FindBy(id = "input-lastname")
    private WebElement lastname;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement phone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmpassword;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement subscribeyes;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    private WebElement subscribeNo;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement policyCheckBox;

    @FindBy(xpath = " //input[@class='btn btn-primary']")
    private WebElement ContinueButton;

    @FindBy(xpath = " //div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement frstnamewarning;

    @FindBy(xpath = " //div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement lastnamewarning;

    @FindBy(xpath = " //div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailwarning;

    @FindBy(xpath = " //div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement phonewarning;

    @FindBy(xpath = " //div[text()='Password must be between 4 and 20 characters!']")
    private WebElement passwordwarning;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement policywarning;

    @FindBy(xpath = "//div[@class='list-group']/a[text()='Register']")
    private WebElement registeroption;

    @FindBy(xpath = "//h1[text()='Register Account']")
    private WebElement registeracct;





    //Method to Enter the FirstName
    public void enterFirstName(String Firstname) {
        actionDriver.enterText((WebElement) firstname, Firstname);

    }

    //Method to Enter the LastName
    public void enterLastName(String Lastname) {
        actionDriver.enterText((WebElement) lastname, Lastname);

    }

    //Method to Enter the Email
    public void enterEmail(String Email) {
        actionDriver.enterText((WebElement) email, Email);
    }

    //Method to Enter the Phone
    public void enterPhone(String Phone) {
        actionDriver.enterText((WebElement) phone, Phone);
    }

    //Method to Enter the Password
    public void enterPassword(String Password) {
        actionDriver.enterText((WebElement) password, Password);
    }

    //Method to Enter the ConfirmPassword
    public void enterConfirmPassword(String ConfirmPassword) {
        actionDriver.enterText((WebElement) confirmpassword, ConfirmPassword);
    }

    //Method to click on SubscribeYes
    public void clickOnSubscribeYes() {
        actionDriver.click((WebElement) subscribeyes);
    }

    //Method to click on SubscribeNo
    public void clickOnSubscribeNo() {
        actionDriver.click((WebElement) subscribeNo);
    }

    //Method to click on PolicyCheckBox
    public void clickOnPolicyCheckBox() {
        actionDriver.click((WebElement) policyCheckBox);
    }

    //Method to click on ContinueButton
    public void clickOnContinueButton() {
        actionDriver.click((WebElement) ContinueButton);
    }

    //Method to Display the warning message for First Name field
    public void displayFirstNameWarning() {
        actionDriver.isDisplayed((WebElement) frstnamewarning);
    }

    //Method to Display the warning message for Last Name field
    public void displayLastNameWarning() {
        actionDriver.isDisplayed((WebElement) lastnamewarning);
    }

    //Method to Display the warning message for Email field
    public void displayEmailWarning() {
        actionDriver.isDisplayed((WebElement) emailwarning);
    }

    //Method to Display the warning message for phone field
    public void displayPhoneWarning() {
        actionDriver.isDisplayed((WebElement) phonewarning);
    }

    //Method to Display the warning message for password field
    public void displayPasswordWarning() {
        actionDriver.isDisplayed((WebElement) passwordwarning);
    }

    //Method to Display the warning message for policy field
    public void displayPolicydWarning() {
        actionDriver.isDisplayed((WebElement) policywarning);
    }

    //Method to click on Register Option
    public void clickOnRegisterOption() {
        actionDriver.click((WebElement) registeroption);
    }

    //Method to Display the warning message for policy field
    public void displayRegisterAccount() {
        actionDriver.isDisplayed((WebElement) registeracct);
    }



}
