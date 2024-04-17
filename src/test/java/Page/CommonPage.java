package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriverConfig.WebDriverSingleton.getDriver;


public class CommonPage extends WebDriverSingleton {

    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement passWord;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "inventory_container")
    private WebElement productPage;

    private static WebDriver driver;

    public CommonPage() {
        PageFactory.initElements(driver = getDriver(), this);
    }

    public void goToHomePage() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com");
    }

    public void closeDriver() {
        driver = cleanDriver();
    }

    public void isLoggedIn(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
    }

    public Boolean isOnProductPage() {
        return productPage.isDisplayed();
    }
}
