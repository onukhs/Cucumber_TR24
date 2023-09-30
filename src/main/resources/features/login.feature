Feature: Login to a website

  Scenario: Success login to a website
    Given I am on the login page
    When I enter valid username and password
    And I click on Login button
    Then I should be logged in

  Scenario Outline: Unsuccesful login
    Given I am on the login page
    When I enter invalid "<username>" and "<password>"
    And I click on Login button
    Then I should see an "<error>"
    But I should not be logged in

    Examples:
      | username        | password     | error                                                                     |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | potato          | potato       | Epic sadface: Username and password do not match any user in this service |
