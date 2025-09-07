Feature: Menu and Logout

  Scenario: Open and close menu
    Given I am logged in with "standard_user" and "secret_sauce"
    When I open the menu
    Then the menu should be visible

  Scenario: Logout from the application
    Given I am logged in with "standard_user" and "secret_sauce"
    When I logout
    Then I should be redirected to the login page
