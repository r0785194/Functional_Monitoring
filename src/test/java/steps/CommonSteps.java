package steps;

import Page.CommonPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    private final CommonPage commonPage = new CommonPage();

    @Before
    public void iGoToWebsite() {
        commonPage.goToHomePage();
    }

    @After
    public void closeDriver(){
        commonPage.closeDriver();
    }

    @Given("I am correctly logged in with username {} and password {}")
    public void iAmCorrectlyLoggedIn(String username, String password) {
        commonPage.isLoggedIn(username,password);
    }

    @Given("I am on the product page")
    public void iAmOnTheProductPage() {
        assertThat(commonPage.isOnProductPage()).as("I am not on the product page").isTrue();
    }
}
