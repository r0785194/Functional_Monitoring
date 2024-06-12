package steps;

import Page.ProductDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailSteps {

    private final ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("I click on the product {string}")
    public void iClickOnTheProduct(String productName) {
        productDetailPage.clickOnProductByName(productName);
    }

    @Then("I’m redirected to the product detail screen of {string}")
    public void iMRedirectedToTheProductDetailScreenOf(String productName) {
        assertThat(productDetailPage.isOnProductDetailPage(productName)).as("I am not redirected to the detail page of the product: " + productName).isTrue();
    }
}
