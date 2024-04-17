package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends WebDriverSingleton {

    @FindBy(css = ".login_logo")
    private WebElement pageTitle;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement passWord;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;
    @FindBy(id = "inventory_container")
    private WebElement productPage;
    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessageContainer;

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    private final WebDriver driver = getDriver();
    public Boolean isTitleCorrect() {
        return pageTitle.getText().equals("Swag Labs");
    }

    public void enterUsername(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String password){
        passWord.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public Boolean isLoggedIn(){
        return menu.isDisplayed();
    }

    public Boolean isOnProductPage() {
        return productPage.isDisplayed();
    }

    public String isErrorMessage(){
        return errorMessageContainer.getText();
    }
}
