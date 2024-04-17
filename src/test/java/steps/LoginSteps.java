package steps;

import Page.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import static org.junit.jupiter.api.Assertions.*;



public class LoginSteps {
    private LogInPage logInPage = new LogInPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        assertTrue(logInPage.isTitleCorrect());
    }

    @When("I fill in my username {}")
    public void iFillInMyUsername(String userName) {
        logInPage.enterUsername(userName);
    }
    @When("I fill in no username")
    public void iFillInNoUsername() {
        String emptyUserName = "";
        logInPage.enterUsername(emptyUserName);
    }

    @When("I fill in my password {}")
    public void iFillInMyPassword(String password) {
        logInPage.enterPassword(password);
    }

    @When("I fill in something that's not my password {}")
    public void iFillInSomethingThatSNotMyPassword(String password) {
        logInPage.enterPassword(password);
    }

    @When("I fill in no password")
    public void iFillInNoPassword() {
        String emptyPassword = "";
        logInPage.enterPassword(emptyPassword);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        logInPage.clickLoginButton();
    }

    @Then("I'm logged in")
    public void imLoggedIn() {
        assertTrue(logInPage.isLoggedIn());
    }

    @Then("redirected to the product page")
    public void redirectedToTheProductPage() {
        assertTrue(logInPage.isOnProductPage());
    }

    @Then("an error message is show that indicates that the combination of the username and password is not a valid one.")
    public void anErrorMessageIsShowThatIndicatesThatTheCombinationOfTheUsernameAndPasswordIsNotAValidOne() {
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(errorMessage, logInPage.isErrorMessage());
    }

    @Then("an error message is show that indicates that the username is a required field.")
    public void anErrorMessageIsShowThatIndicatesThatTheUsernameIsARequiredField() {
        String errorMessage = "Epic sadface: Username is required";
        assertEquals(errorMessage, logInPage.isErrorMessage());
    }

    @Then("an error message is show that indicates that the password is a required field.")
    public void anErrorMessageIsShowThatIndicatesThatThePasswordIsARequiredField() {
        String errorMessage = "Epic sadface: Password is required";
        assertEquals(errorMessage, logInPage.isErrorMessage());
    }
}
