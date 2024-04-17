package steps;

import Page.ProductDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDetailSteps {

    private final ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("I click on a product")
    public void iClickOnAProduct() {
        productDetailPage.clickOnProduct();
    }

    @Then("I’m redirected to the product detail screen of that specific product")
    public void iMRedirectedToTheProductDetailScreenOfThatSpecificProduct() {
        assertTrue(productDetailPage.isOnProductDetailPage());
    }
}
