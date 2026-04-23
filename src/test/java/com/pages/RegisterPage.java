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


}
