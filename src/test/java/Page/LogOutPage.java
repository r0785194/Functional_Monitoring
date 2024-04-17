package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage extends WebDriverSingleton {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;
    @FindBy(css = ".bm-menu-wrap")
    private WebElement menuButtons;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;
    @FindBy(id = "login_button_container")
    private WebElement logInContainer;
    @FindBy(css = ".login_logo")
    private WebElement pageTitle;

    public LogOutPage() {
        PageFactory.initElements(driver, this);
    }

    private final WebDriver driver = getDriver();

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public Boolean areButtonsDisplayed() {
        return menuButtons.isDisplayed();
    }

    public void clickLogOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logoutButton.click();
    }

    public boolean isLoggedOut() {
        return logInContainer.isDisplayed();
    }

    public boolean isOnHomeScreen() {
        return pageTitle.getText().equals("Swag Labs");
    }
}
