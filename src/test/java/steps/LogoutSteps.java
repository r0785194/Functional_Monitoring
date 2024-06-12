package steps;

import Page.LogOutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoutSteps {

    private final LogOutPage logOutPage = new LogOutPage();

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
        assertThat(logOutPage.areButtonsDisplayed()).as("I dont see the list of buttons").isTrue();
    }

    @Then("I am logged out of the application")
    public void iAmLoggedOutOfTheApplication() {
        assertThat(logOutPage.isLoggedOut()).as("I am not logged out").isTrue();
    }

    @Then("redirected to the Home Screen the login screen")
    public void redirectedToTheHomeScreenTheLoginScreen() {
        assertThat(logOutPage.isOnHomeScreen())
                .as("I am not redirected to the login page").isTrue();
    }
}
