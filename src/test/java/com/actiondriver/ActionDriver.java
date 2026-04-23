package com.actiondriver;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class ActionDriver {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize the driver and explicit wait
    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        int explicitWait = Integer.parseInt(BaseClass.getProperties().getProperty("explicitWait"));
        this.wait  = new WebDriverWait(driver,Duration.ofSeconds(explicitWait));
    }

    // method to wait for an element to be clickable
    private void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element not clickable: " + e.getMessage());

        }
    }

    // method to wait for an element to be visible
    private void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element not visible: " + e.getMessage());
        }
    }

    // method to click on an element
    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to click on element: " + e.getMessage());
        }
    }

    // method to enter text into an element
    public void enterText(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Failed to enter text: " + e.getMessage());
        }
    }

    // method to get text from an element
    public String getText(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return element.getText();
        } catch (Exception e) {
            System.out.println("Failed to get text: " + e.getMessage());
            return "";
        }
    }

    // method to get title of the page
    public void getTitle(String expectedTitle) {
        try {
            waitForPageLoad(10);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Titles are matching: "+ actualTitle +" equals "+expectedTitle);
            }else {
                System.out.println("Titles are not matching: "+ actualTitle +" not equals "+expectedTitle);
            }
        } catch (Exception e) {
            System.out.println("Failed to get title: " + e.getMessage());
        }
    }

    // method to compare text from an element
    public void compareText(WebElement element, String expectedText) {
        try {
            waitForElementToBeVisible(element);
            String actualText = element.getText();
            if(expectedText.equals(actualText)) {
                System.out.println("Texts are matching: "+actualText+" equals "+expectedText);
            } else {
                System.out.println("Texts are not matching: "+actualText+" not equals "+expectedText);
            }
        } catch (Exception e) {
            System.out.println("Failed to compare text: " + e.getMessage());
        }
    }

    // method to check if an element is displayed
    public boolean isDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return element.isDisplayed();

        } catch (Exception e) {
            System.out.println("Failed to check if element is displayed: " + e.getMessage());
        }
        return false;
    }

    // method to scroll to an element
    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to element successfully");
        } catch (Exception e) {
            System.out.println("Failed to scroll to element: " + e.getMessage());
        }

    }

    // method to wait for a page to load
    private void waitForPageLoad(int timeOutInSeconds){
        try {
            wait.withTimeout(Duration.ofSeconds(timeOutInSeconds)).until(webDriver -> (
                    (JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            System.out.println("Page loaded successfully");
        } catch (Exception e) {
            System.out.println("page did not load within " + timeOutInSeconds + " seconds.Exception: " + e.getMessage());
        }

    }

    // method to accept an alert
    public  void  acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert accepted successfully");
        } catch (Exception e) {
            System.out.println("Failed to accept alert: " + e.getMessage());
        }
    }

    // method to dismiss an alert
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            System.out.println("Alert dismissed successfully");
        }catch (Exception e){
            System.out.println("Failed to dismiss alert: " + e.getMessage());
        }
    }








}
