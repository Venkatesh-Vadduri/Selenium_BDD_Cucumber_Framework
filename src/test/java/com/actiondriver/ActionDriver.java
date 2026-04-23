package com.actiondriver;

import com.base.BaseClass;
import org.apache.logging.log4j.Logger;
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

    public static final Logger logger = BaseClass.logger;

    // Constructor to initialize the driver and explicit wait
    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        int explicitWait = Integer.parseInt(BaseClass.getProperties().getProperty("explicitWait"));
        this.wait  = new WebDriverWait(driver,Duration.ofSeconds(explicitWait));
        logger.info("Webdriver instance is created successfully");
    }

    // method to wait for an element to be clickable
    private void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("Element is clickable");
        } catch (Exception e) {
            logger.error("unable to click element: " + e.getMessage());

        }
    }

    // method to wait for an element to be visible
    private void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element is visible");
        } catch (Exception e) {
            logger.error("Element is not visible: " + e.getMessage());
        }
    }

    // method to click on an element
    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            logger.info("Element clicked successfully");
        } catch (Exception e) {
            logger.error("Failed to click on element: " + e.getMessage());
        }
    }

    // method to enter text into an element
    public void enterText(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
            logger.info("Text entered successfully");
        } catch (Exception e) {
            logger.error("Failed to enter text: " + e.getMessage());
        }
    }

    // method to get text from an element
    public String getText(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            logger.info("Text retrieved from element successfully");
            return element.getText();

        } catch (Exception e) {
            logger.error("Failed to get text: " + e.getMessage());
            return "";
        }
    }

    // method to get title of the page
    public void getTitle(String expectedTitle) {
        try {
            waitForPageLoad(10);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                logger.info("Titles are matching: "+ actualTitle +" equals "+expectedTitle);
            }else {
                logger.error("Titles are not matching: "+ actualTitle +" not equals "+expectedTitle);
            }
        } catch (Exception e) {
            logger.error("Failed to get title: " + e.getMessage());
        }
    }

    // method to compare text from an element
    public boolean compareText(WebElement element, String expectedText) {
        try {
            waitForElementToBeVisible(element);
            String actualText = element.getText();
            if(expectedText.equals(actualText)) {
                logger.info("Texts are matching: "+actualText+" equals "+expectedText);
                return true;
            } else {
                logger.error("Texts are not matching: "+actualText+" not equals "+expectedText);
                return false;
            }
        } catch (Exception e) {
            logger.error("Failed to compare text: " + e.getMessage());
            return false;
        }
    }

    // method to check if an element is displayed
    public boolean isDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            logger.info("Element is displayed successfully");
            return element.isDisplayed();

        } catch (Exception e) {
            logger.error("Failed to check if element is displayed: " + e.getMessage());
        }
        return false;
    }

    // method to scroll to an element
    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element successfully");
        } catch (Exception e) {
            logger.error("Failed to scroll to element: " + e.getMessage());
        }

    }

    // method to wait for a page to load
    private void waitForPageLoad(int timeOutInSeconds){
        try {
            wait.withTimeout(Duration.ofSeconds(timeOutInSeconds)).until(webDriver -> (
                    (JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            logger.info("Page loaded successfully");
        } catch (Exception e) {
            logger.error("page did not load within " + timeOutInSeconds + " seconds.Exception: " + e.getMessage());
        }

    }

    // method to accept an alert
    public  void  acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            logger.info("Alert accepted successfully");
        } catch (Exception e) {
            logger.error("Failed to accept alert: " + e.getMessage());
        }
    }

    // method to dismiss an alert
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            logger.info("Alert dismissed successfully");
        }catch (Exception e){
            logger.error("Failed to dismiss alert: " + e.getMessage());
        }
    }








}
