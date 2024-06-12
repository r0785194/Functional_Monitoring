package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ShoppingCartPage extends WebDriverSingleton {

    @FindBy(css = ".btn_primary")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".btn_secondary.btn_small")
    private List<WebElement> removeFromCartButtons;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemName;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css = ".inventory_item_name")
    private WebElement cartItemName;

    @FindBy(css = ".cart_list > div")
    private List<WebElement> cartListDivs;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItemsList;

    @FindBy(css = ".removed_cart_item")
    private List<WebElement> removedCartItems;

    @FindBy(id = "cart_contents_container")
    private WebElement cartPage;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".title")
    private WebElement checkoutTitle;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutComplete;

    private int clickedItem;

    private String addedItemName;
    private int initialItemCount;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    private final WebDriver driver = getDriver();

    public void clickOnAddToCart() {
        clickedItem = new Random().nextInt(addToCartButtons.size());
        addToCartButtons.get(clickedItem).click();
    }

    public void clickRemoveFromCart() {
        initialItemCount = cartItemsList.size();
        removeFromCartButtons.get(0).click();
    }

    public void getAddedItemName() {
        addedItemName = itemName.get(clickedItem).getText();
    }

    public Boolean isCartBadgeShown() {
        try {
            return cartBadge != null && cartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToCart() {
        cart.click();
    }

    public Boolean isAddedToCart() {
        return cartItemName.getText().equals(addedItemName);
    }

    public Boolean isRemovedFromCart() {
        return addToCartButtons.get(clickedItem).isDisplayed();
    }

    public Boolean isOnCartPage() {
        return cartPage.isDisplayed();
    }

    public Boolean isCartEmpty() {
        return cartListDivs.size() == 2;
    }

    public Boolean itemRemovedFromCart() {
        return !removedCartItems.isEmpty();
    }

    public Boolean isListUpdated() {
        try {
            int finalItemCount = cartItemsList.size();
            return finalItemCount < initialItemCount;
        } catch (Exception e) {
            return true;
        }
    }

    public void clickOnCheckout() {
        checkoutButton.click();
    }

    public Boolean isOnCheckout() {
        return checkoutTitle.getText().equals("Checkout: Your Information");
    }

    public void filledFields() {
        firstName.sendKeys("john");
        lastName.sendKeys("doe");
        postalCode.sendKeys("3960");
    }

    public void clickOnContinue() {
        continueButton.click();
    }

    public Boolean isOnCheckoutOverview() {
        return checkoutTitle.getText().equals("Checkout: Overview");
    }

    public void clickOnFinish() {
        finishButton.click();
    }

    public Boolean isCheckoutComplete() {
        return checkoutComplete.isDisplayed();
    }
}
