package com.pages;

import com.actiondriver.ActionDriver;
import com.utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage {

    public WebDriver driver;
    public ActionDriver actionDriver;
    public ExcelReader excelReader;
    public  LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        this.actionDriver = new ActionDriver(driver);
        this.excelReader = new ExcelReader();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginbutton;


    public void clickonContinueButton() {
        actionDriver.click(continueButton);
    }

    public void enterEmail(String Email) {
        actionDriver.enterText((WebElement) email, Email);
    }


    public void enterPassword(String Password) {
        actionDriver.enterText((WebElement) password, Password);
    }

    public void clickonLoginButton() {
        actionDriver.click(loginbutton);
    }


    public void enterUserName() {
        List<String> usernames = excelReader.getExcelData("Login","UserName");
        usernames.get(0);
        System.out.println( usernames.get(0));
        actionDriver.enterText((WebElement) email, usernames.get(0));
    }

    public void enterPassword() {
        List<String> passwords = excelReader.getExcelData("Login","Password");
        passwords.get(0);
        System.out.println( passwords.get(0));
        actionDriver.enterText((WebElement) email, passwords.get(0));

    }






}

