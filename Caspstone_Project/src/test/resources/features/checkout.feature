Feature: Checkout functionality

  Scenario: Complete checkout process
    Given I have an item in my cart
    When I proceed to checkout with first name "John", last name "Doe", and postal code "12345"
    And I finish the order
    Then I should see the order confirmation message
