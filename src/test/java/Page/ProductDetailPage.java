package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailPage extends WebDriverSingleton {

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(css = ".inventory_details_name")
    private WebElement productDetailName;

    public ProductDetailPage() {
        PageFactory.initElements(driver, this);
    }
    private final WebDriver driver = getDriver();

    public void clickOnProductByName(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                productNames.get(i).click();
                break;
            }
        }
    }

    public Boolean isOnProductDetailPage(String productName) {
        return  productDetailName.getText().equals(productName);
    }
}
