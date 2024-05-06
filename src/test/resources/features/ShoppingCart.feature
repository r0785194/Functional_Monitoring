@Regression
Feature: Shopping Cart Functionality

  Background:
    Given I am correctly logged in with username standard_user and password secret_sauce
    And I am on the product page

  @Sanity
  Scenario:Add products to the cart
    When I click on the ‘add to cart’ next to a product
    And I click on the shopping cart icon
    Then I’m redirected to the ‘your cart’ screen
    And the product is added to my cart

  @Sanity
  Scenario: I don’t have a product added to my cart
    When I click on the shopping cart icon
    Then I’m redirected to the ‘your cart’ screen
    And the list of products in my cart is empty

  @Sanity
  Scenario: deleting it from the product overview page
    When I click on the ‘remove' button in my overview page next to a product that I’ve added to my cart
    Then that product is removed from my cart in overview

  @Sanity
  Scenario: deleting it from the your cart page
    Given I am on the ‘Your cart’ page
    When I click on the ‘remove' button next to a product that I’ve added to my cart
    Then that product is removed from my cart
    And the list updates itself and I don’t see the product anymore that I just deleted

  @Sanity
    Scenario: Check out the products
      Given I am on the ‘Your cart’ page
      When I click on ‘check out’
      Then I am redirected to the ‘Checkout: your information’ page
      When I complete filling out the fields
      And click on continue
      Then I’m redirected to the ‘checkout: overview page’
      When I click on ‘finish’
      Then I see an order confirmation screen