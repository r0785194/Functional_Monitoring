package DriverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class WebDriverSingleton {
    private static ChromeOptions options = new ChromeOptions();

    public static ChromeOptions getOptions() {
        options.addArguments("--no-sandbox");
        return options;
    }
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            if (isRunningOnCircleCI()){
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getOptions());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                driver = new ChromeDriver(getOptions());
            }
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

    private static boolean isRunningOnCircleCI() {
        return Boolean.parseBoolean(System.getenv("CI"));
    }
}
