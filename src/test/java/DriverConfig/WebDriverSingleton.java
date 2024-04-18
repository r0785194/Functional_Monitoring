package DriverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WebDriverSingleton {

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static WebDriver cleanDriver() {
        if (driver != null) {
            // Quit WebDriver session
            driver.quit();
        }
        return driver = null;
    }
}
