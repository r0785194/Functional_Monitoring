package steps;

import Page.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartSteps {

    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Given("I am on the ‘Your cart’ page")
    public void iAmOnTheYourCartPage() {
        shoppingCartPage.goToCart();
        shoppingCartPage.isOnCartPage();
    }

    @When("I click on the ‘add to cart’ next to a product")
    public void iClickOnTheAddToCartNextToAProduct() {
        shoppingCartPage.clickOnAddToCart();
        shoppingCartPage.getAddedItemName();
        assertThat(shoppingCartPage.isCartBadgeShown())
                .as("The badge was not added to the shopping cart icon").isTrue();
    }

    @When("I click on the shopping cart icon")
    public void iClickOnTheShoppingCartIcon() {
        shoppingCartPage.goToCart();
    }

    @When("I click on the remove button in my overview page from the product I’ve added to my cart")
    public void iClickOnTheRemoveButtonInMyOverviewPageFromTheProductIVeAddedToMyCart() {
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
        shoppingCartPage.goToCart();
        assertThat(shoppingCartPage.isAddedToCart())
                .as("The product was not added to the cart").isTrue();
    }

    @Then("I’m redirected to the ‘your cart’ screen")
    public void iMRedirectedToTheYourCartScreen() {
        assertThat(shoppingCartPage.isOnCartPage())
                .as("I am not redirected to my cart").isTrue();
    }

    @Then("the list of products in my cart is empty")
    public void theListOfProductsInMyCartIsEmpty() {
        assertThat(shoppingCartPage.isCartEmpty())
                .as("There are still products in my cart").isTrue();
    }

    @Then("that product is removed from my cart in overview")
    public void thatProductIsRemovedFromMyCartInOverview() {
        assertThat(shoppingCartPage.isRemovedFromCart())
                .as("The product was not removed from my cart in the overview page").isTrue();
    }
    @Then("that product is removed from my cart")
    public void thatProductIsRemovedFromMyCart() {
        assertThat(shoppingCartPage.itemRemovedFromCart())
                .as("The product was not removed from my cart").isTrue();
    }

    @Then("the list updates itself and I don’t see the product anymore that I just deleted")
    public void theListUpdatesItselfAndIDonTSeeTheProductAnymoreThatIJustDeleted() {
        assertThat(shoppingCartPage.isListUpdated())
                .as("The deleted product is still shown in the list").isTrue();
    }

    @Then("I am redirected to the ‘Checkout: your information’ page")
    public void iAmRedirectedToTheCheckoutYourInformationPage() {
        assertThat(shoppingCartPage.isOnCheckout())
                .as("I am not redirected to the your information page in checkout").isTrue();
    }

    @Then("I’m redirected to the ‘checkout: overview page’")
    public void iMRedirectedToTheCheckoutOverviewPage() {
        assertThat(shoppingCartPage.isOnCheckoutOverview())
                .as("I am not redirected to the overview page in checkout").isTrue();
    }

    @Then("I see an order confirmation screen")
    public void iSeeAOrderConfirmationScreen() {
        assertThat(shoppingCartPage.isCheckoutComplete())
                .as("I dont see an order confirmation screen").isTrue();
    }
}
