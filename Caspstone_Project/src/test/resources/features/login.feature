Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the products page

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I login with username "wrong_user" and password "wrong_pass"
    Then I should see an error message
