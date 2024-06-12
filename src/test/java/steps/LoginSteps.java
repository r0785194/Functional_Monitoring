package steps;

import Page.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;



public class LoginSteps {
    private final LogInPage logInPage = new LogInPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        assertThat(logInPage.isTitleCorrect()).as("I am not on the login page").isTrue();
    }

    @When("I fill in my username {}")
    public void iFillInMyUsername(String userName) {
        logInPage.enterUsername(userName);
    }

    @When("I fill in my password {}")
    public void iFillInMyPassword(String password) {
        logInPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        logInPage.clickLoginButton();
    }

    @Then("I'm logged in")
    public void imLoggedIn() {
        assertThat(logInPage.isLoggedIn()).as("I am not logged in").isTrue();
    }

    @Then("redirected to the product page")
    public void redirectedToTheProductPage() {
        assertThat(logInPage.isOnProductPage()).as("I am not redirected to the product overview page").isTrue();
    }

    @Then("an error message in login page is shown {}")
    public void anErrorMessageInLoginPageIsShown(String errorMessage)
    {
        assertThat(logInPage.isErrorMessage().contains(errorMessage)).as("No error message is shown on the login page").isTrue();
    }

    @Then("a red cross is shown by the username and password")
    public void aRedCrossIsShownByTheUsernameAndPassword() {
        assertThat(logInPage.redCrossIsShown()).as("The red cross is not shown").isTrue();
    }
}
