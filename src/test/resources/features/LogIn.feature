Feature: Log in to the website

  @Smoke
  Scenario: Successful Login
    Given I am on the login page
    When I fill in my username standard_user
    And I fill in my password secret_sauce
    And I click on the login button
    Then I'm logged in
    And redirected to the product page
  @Sanity
  Scenario: failed login: correct username - wrong password
    Given I am on the login page
    When I fill in my username standard_user
    And I fill in something that's not my password password
    And I click on the login button
    Then an error message is show that indicates that the combination of the username and password is not a valid one.
  @Sanity
  Scenario: failed login: no username filled out - password filled out
    Given I am on the login page
    When I fill in no username
    And I fill in my password secret_sauce
    And I click on the login button
    Then an error message is show that indicates that the username is a required field.
  @Sanity
  Scenario: failed login: username filled out - no password filled out
    Given I am on the login page
    When I fill in my username standard_user
    And I fill in no password
    And I click on the login button
    Then an error message is show that indicates that the password is a required field.

