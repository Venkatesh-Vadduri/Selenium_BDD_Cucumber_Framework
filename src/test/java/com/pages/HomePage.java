package com.pages;

import com.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public WebDriver driver;
    public ActionDriver actionDriver;


    public  HomePage(WebDriver driver) {
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver, this);
    }


    //Define Locators using Page Factory
    @FindBy(xpath = "//span[text()='My Account']")
   private WebElement myaccountdropdown;

    @FindBy(xpath = "//a[text()='Login']")
    private   WebElement loginoption;

    @FindBy(xpath = "//a[text()='Register']")
    private  WebElement registeroption;

    @FindBy(name = "search")
    private  WebElement searchfield;

    @FindBy(xpath = "//button[contains(@class,'btn btn-default')")
    private  WebElement searchButton;


    //Method to click on MyAccount Dropdown
    public void clickMyAccountDropdown() {
        actionDriver.click((WebElement) myaccountdropdown);
    }

    //Method to click on Login Option
    public void clickLoginOption() {
        actionDriver.click((WebElement) loginoption);
    }

    //Method to click on Register Option
    public void clickRegisterOption() {
        actionDriver.click((WebElement) registeroption);
    }

    //Method to enter text into Search Field
    public void enterTextIntoSearchField(String text) {
        actionDriver.enterText((WebElement) searchfield,text);
    }

    //Method to click on Search Button
    public void clickOnSearchButton() {
        actionDriver.click((WebElement) searchButton);
    }



}

