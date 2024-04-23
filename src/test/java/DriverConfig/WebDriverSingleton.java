package DriverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public abstract class WebDriverSingleton {
    private static ChromeOptions options = new ChromeOptions();

    public static ChromeOptions getOptions() {
        options.addArguments("--no-sandbox");
        return options;
    }
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                driver = isRunningOnCircleCI() ? new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getOptions()) : new ChromeDriver(getOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException("Fout bij het maken van de URL voor de RemoteWebDriver", e);
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
        return Optional.ofNullable(System.getenv("CI")).map(Boolean::parseBoolean).orElse(false);
    }
}
