package steps;

import Page.SortingProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingProductPageSteps {

    private final SortingProductPage sortingProductPage = new SortingProductPage();

    @When("I click on the filter option button")
    public void iClickOnTheFilterOptionButton() {
        sortingProductPage.clickOnFilterOption();
    }

    @When("click on ‘Name \\(A to Z)’")
    public void clickOnNameAToZ() {
        sortingProductPage.selectOptionAToZ();
    }

    @When("click on ‘Price \\(low to high)’")
    public void clickOnPriceLowToHigh() {
        sortingProductPage.selectOptionLoToHi();
    }

    @Then("the products are shown in alphabetical order")
    public void theProductsAreShownInAlphabeticalOrder() {
        assertTrue(sortingProductPage.isSortedAToZ());
    }

    @Then("I see the products ordered with the product lowest price first and highest price last")
    public void iSeeTheProductsOrderedWithTheProductLowestPriceFirstAndHighestPriceLast() {
        assertTrue(sortingProductPage.isSortedLoToHi());
    }
}
