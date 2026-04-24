package com.pages;

import com.actiondriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;
    ActionDriver actionDriver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver, this);

    }

    //Define Locators using Page Factory
    @FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
    private WebElement newsletter;





    //Method to click on Subscribe / Unsubscribe to Newsletter
    public void clickOnNewsletter() {
        actionDriver.click((WebElement) newsletter);
    }





}
