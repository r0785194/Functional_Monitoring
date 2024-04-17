package steps;

import Page.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {

    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Given("I am on the ‘Your cart’ page")
    public void iAmOnTheYourCartPage() {
        shoppingCartPage.clickOnAddToCart();
        shoppingCartPage.goToCart();
        shoppingCartPage.isOnCartPage();
    }

    @When("I click on the ‘add to cart’ next to a product")
    public void iClickOnTheAddToCartNextToAProduct() {
        shoppingCartPage.clickOnAddToCart();
    }

    @When("I click on the shopping cart icon")
    public void iClickOnTheShoppingCartIcon() {
        shoppingCartPage.goToCart();
    }

    @When("I click on the ‘remove' button in my overview page next to a product that I’ve added to my cart")
    public void iClickOnTheRemoveButtonInMyOverviewPageNextToAProductThatIVeAddedToMyCart() {
        shoppingCartPage.clickOnAddToCart();
        shoppingCartPage.clickRemoveFromCart();
    }

    @When("I click on the ‘remove' button next to a product that I’ve added to my cart")
    public void iClickOnTheRemoveButtonNextToAProductThatIVeAddedToMyCart() {
        shoppingCartPage.clickRemoveFromCart();
    }

    @When("I click on ‘check out’")
    public void iClickOnCheckOut() {
        shoppingCartPage.clickOnCheckout();
    }

    @When("I complete filling out the fields")
    public void iCompleteFillingOutTheFields() {
        shoppingCartPage.filledFields();
    }

    @When("click on continue")
    public void clickOnContinue() {
        shoppingCartPage.clickOnContinue();
    }

    @When("I click on ‘finish’")
    public void iClickOnFinish() {
        shoppingCartPage.clickOnFinish();
    }

    @Then("the product is added to my cart")
    public void theProductIsAddedToMyCart() {
        shoppingCartPage.getAddedItemName();
        assertThat(shoppingCartPage.isCartBadgeShown()).isTrue();
        shoppingCartPage.goToCart();
        assertTrue(shoppingCartPage.isAddedToCart());
    }

    @Then("I’m redirected to the ‘your cart’ screen")
    public void iMRedirectedToTheYourCartScreen() {
        assertTrue(shoppingCartPage.isOnCartPage());
    }

    @Then("I can see all the products that I’ve added to my cart")
    public void iCanSeeAllTheProductsThatIVeAddedToMyCart() {
    }

    @Then("the list of products in my cart is empty")
    public void theListOfProductsInMyCartIsEmpty() {
        assertTrue(shoppingCartPage.isCartEmpty());
    }

    @Then("that product is removed from my cart in overview")
    public void thatProductIsRemovedFromMyCartInOverview() {
        assertTrue(shoppingCartPage.isRemovedFromCart());
    }
    @Then("that product is removed from my cart")
    public void thatProductIsRemovedFromMyCart() {
        assertTrue(shoppingCartPage.itemRemovedFromCart());
    }

    @Then("the list updates itself and I don’t see the product anymore that I just deleted")
    public void theListUpdatesItselfAndIDonTSeeTheProductAnymoreThatIJustDeleted() {
        assertTrue(shoppingCartPage.isListUpdated());
    }

    @Then("I am redirected to the ‘Checkout: your information’ page")
    public void iAmRedirectedToTheCheckoutYourInformationPage() {
        assertTrue(shoppingCartPage.isOnCheckout());
    }

    @Then("I’m redirected to the ‘checkout: overview page’")
    public void iMRedirectedToTheCheckoutOverviewPage() {
        assertTrue(shoppingCartPage.isOnCheckoutOverview());
    }

    @Then("I see a order confirmation screen")
    public void iSeeAOrderConfirmationScreen() {
        assertTrue(shoppingCartPage.isCheckoutComplete());
    }
}
