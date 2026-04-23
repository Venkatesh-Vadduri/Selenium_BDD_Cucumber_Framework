package com.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public void loadConfig() throws IOException {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load config.properties file: "+e.getMessage());
        }
    }

    private void launchBrowser() {
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
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
        } catch (Exception e) {
            System.out.println("Failed to launch URL: " +e.getMessage());
        }
    }

    @Before
    public void setUp() throws IOException {
        loadConfig();
        launchBrowser();
        configBrowse();
        staticWait(2);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Failed to quit driver: "+e.getMessage());
            }
        }
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
}
