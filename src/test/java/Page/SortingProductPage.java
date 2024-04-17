package Page;

import DriverConfig.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SortingProductPage extends WebDriverSingleton {

    @FindBy(css = ".product_sort_container")
    private WebElement sortButton;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemName;

    public SortingProductPage() {
        PageFactory.initElements(driver, this);
    }
    private final WebDriver driver = getDriver();

    public void clickOnFilterOption() {
        sortButton.click();
    }

    public void selectOptionAToZ() {
        Select select = new Select(sortButton);
        select.selectByValue("az");
    }

    public Boolean isSortedAToZ() {
       return itemName.get(0).getText().equals("Sauce Labs Backpack");
    }

    public void selectOptionLoToHi() {
        Select select = new Select(sortButton);
        select.selectByValue("lohi");
    }

    public boolean isSortedLoToHi() {
        return itemName.get(0).getText().equals("Sauce Labs Onesie");
    }
}
