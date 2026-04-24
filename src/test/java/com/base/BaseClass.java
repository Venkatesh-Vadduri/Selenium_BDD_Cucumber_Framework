package com.base;

import com.actiondriver.ActionDriver;
import com.utils.LoggerManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static Date date;
    public static File screenshot;
    public static final Logger logger = LoggerManager.getLogger(BaseClass.class);


    public void loadConfig() throws IOException {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            logger.info("Config.properties file loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load config.properties file: " + e.getMessage());
        }
    }

    private void launchBrowser() {
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Chrome browser instance launched successfully");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Firefox browser instance launched successfully");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Edge browser instance launched successfully");
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    private void configBrowse() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        try {
            driver.get(prop.getProperty("url"));
            logger.info("URL launched successfully");
        } catch (Exception e) {
            logger.error("Failed to launch URL: " + e.getMessage());
        }
    }

    @Before
    public void setUp() throws IOException {
        loadConfig();
        launchBrowser();
        configBrowse();
        staticWait(2);
        logger.info("WebDriver initialized and window is maximised and url loaded successfully");
        logger.trace("This is an Trace messgge");
        logger.error("This is an Error message");
        logger.debug("This is an Debug message");
        logger.fatal("This is an fatal message");
        logger.warn("This is an warning message");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Driver instance closed successfully");
            } catch (Exception e) {
                logger.error("Failed to quit driver: " + e.getMessage());
            }
        }

    }

    @AfterStep
    public void addScreenShot(Scenario scenario) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

    public void staticWait(int seconds) {

        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
    }

    public static Properties getProperties() {
        return prop;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String generateEmail() {
        date = new Date();
        String emailwithoutletters = date.toString().replaceAll("\\s", "").replaceAll("\\:", "").replaceAll("\\p{L}", "");
        String email = "venkatesh" + emailwithoutletters + "@gamil.com";
        System.out.println(email);
        logger.info("Email generated successfully");
        return email;

    }

}
