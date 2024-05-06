@Regression
Feature: Sorting ProductPage

  Background:
    Given I am correctly logged in with username standard_user and password secret_sauce

  @Sanity
  Scenario:  sorting method ‘Name (A to Z)’
    Given I am on the product page
    When I click on the filter option button
    And click on ‘Name (A to Z)’
    Then the products are shown in alphabetical order

  @Sanity
  Scenario: sorting method ‘Price (low to high)’
    Given I am on the product page
    When I click on the filter option button
    And click on ‘Price (low to high)’
    Then I see the products ordered with the product lowest price first and highest price last