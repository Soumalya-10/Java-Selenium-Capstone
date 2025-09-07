Feature: Cart functionality

  Scenario: Add item to cart
    Given I am logged in with "standard_user" and "secret_sauce"
    When I add "Sauce Labs Backpack" to the cart
    Then the cart count should be 1

  Scenario: Remove item from cart
    Given I have "Sauce Labs Backpack" in my cart
    When I remove it from the cart
    Then the cart should be empty
