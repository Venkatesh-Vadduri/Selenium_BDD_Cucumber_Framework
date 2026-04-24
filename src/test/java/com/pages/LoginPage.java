package com.pages;

import com.actiondriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public ActionDriver actionDriver;
    public  LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public void clickonContinueButton() {
        actionDriver.click(continueButton);
    }










}

