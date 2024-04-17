package steps;

import Page.LogOutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogoutSteps {

    private LogOutPage logOutPage = new LogOutPage();

    @When("I click on the hamburger menu in the nav. bar")
    public void iClickOnTheHamburgerMenuInTheNavBar() {
        logOutPage.clickOnHamburgerMenu();
    }

    @When("I click on logout")
    public void iClickOnLogout() {
        logOutPage.clickLogOutButton();
    }

    @Then("I see a list of buttons")
    public void iSeeAListOfButtons() {
        assertTrue(logOutPage.areButtonsDisplayed());
    }

    @Then("I am logged out of the application")
    public void iAmLoggedOutOfTheApplication() {
        assertTrue(logOutPage.isLoggedOut());
    }

    @Then("redirected to the Home Screen the login screen")
    public void redirectedToTheHomeScreenTheLoginScreen() {
        assertTrue(logOutPage.isOnHomeScreen());
    }
}
