Feature: Product Sorting

  Scenario: Sort products by name (A to Z)
    Given I am logged in with "standard_user" and "secret_sauce"
    When I sort products by "az"
    Then products should be sorted by name ascending

  Scenario: Sort products by price (High to Low)
    Given I am logged in with "standard_user" and "secret_sauce"
    When I sort products by "hilo"
    Then products should be sorted by price high to low
