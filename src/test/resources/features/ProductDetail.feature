Feature: See the product detail page

Background:
Given I am correctly logged in with username standard_user and password secret_sauce
  @Sanity
  Scenario: See product detail page
  Given I am on the product page
  When I click on a product
  Then I’m redirected to the product detail screen of that specific product