package com.pages;

import com.actiondriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

    public WebDriver driver;
    ActionDriver actionDriver;

    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement successHeading;

    @FindBy(xpath = "//div[@id='content']/p[contains(text(),'Congratulations! Your new account')]")
    private WebElement successHeading1;

    @FindBy(xpath = "//div[@id='content']/p[contains(text(),'You can now take advantage')]")
    private WebElement successHeading2;

    @FindBy(xpath = "//div[@id='content']/p[contains(text(),'If you have ANY questions')]")
    private WebElement successHeading3;

    @FindBy(xpath = " //a[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement newsletteryesoption;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    private WebElement newsletternooption;




    public String getPageHeading() {
        return actionDriver.getText(successHeading);
    }

    public String getPageHeading1() {
       return actionDriver.getText(successHeading1);
    }

    public String getPageHeading2() {
        return actionDriver.getText(successHeading2);
    }
    public String getPageHeading3() {
        return actionDriver.getText(successHeading3);
    }

    public void clickOnContinueButtonInAccSuccessPage() {
        actionDriver.click(continueButton);
    }

    //method to check yes option is Displayed
    public void getYesNewsLetterOption() {
        actionDriver.isDisplayed((WebElement) newsletteryesoption);
    }

    //method to check No option is Displayed
    public void getNoNewsLetterOption() {
        actionDriver.isDisplayed((WebElement) newsletternooption);
    }

}
