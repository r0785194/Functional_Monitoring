package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends WebDriverSingleton {

    @FindBy(id = "item_4_img_link")
    private WebElement productLink;

    @FindBy(id = "inventory_item_container")
    private WebElement productDetail;

    public ProductDetailPage() {
        PageFactory.initElements(driver, this);
    }
    private final WebDriver driver = getDriver();

    public void clickOnProduct() {
        productLink.click();
    }

    public Boolean isOnProductDetailPage() {
        return  productDetail.isDisplayed();
    }
}
